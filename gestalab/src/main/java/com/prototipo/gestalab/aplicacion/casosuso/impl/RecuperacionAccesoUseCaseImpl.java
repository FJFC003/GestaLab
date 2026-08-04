package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HexFormat;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecuperacionAccesoUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.salida.INotificadorRecuperacion;
import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.dominio.entidades.TokenRecuperacion;
import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.dominio.excepciones.CredencialesInvalidasException;
import com.prototipo.gestalab.dominio.repositorio.IEmpleadoRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ITokenRecuperacionRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;


public class RecuperacionAccesoUseCaseImpl implements IRecuperacionAccesoUseCase{
	
	private static final String ROL_AUTORIZADO = "Gerente General";

	private static final String MENSAJE_RECHAZO =
			"No se pudo iniciar la recuperación con ese correo. "
			+ "Verifique que sea el correo laboral de la Gerente General.";

	private static final int LONGITUD_MINIMA_CONTRASENIA = 8;

	private static final int BYTES_DEL_TOKEN = 32;

	private final IUsuarioRepositorio usuarioRepositorio;
	private final IUsuariohasRolRepositorio usuariohasRolRepositorio;
	private final IEmpleadoRepositorio empleadoRepositorio;
	private final ITokenRecuperacionRepositorio tokenRepositorio;
	private final INotificadorRecuperacion notificador;
	private final PasswordEncoder passwordEncoder;
	private final String baseUrlCliente;
	private final int minutosValidez;

	private final SecureRandom aleatorio = new SecureRandom();

	public RecuperacionAccesoUseCaseImpl(IUsuarioRepositorio usuarioRepositorio,
			IUsuariohasRolRepositorio usuariohasRolRepositorio,
			IEmpleadoRepositorio empleadoRepositorio,
			ITokenRecuperacionRepositorio tokenRepositorio,
			INotificadorRecuperacion notificador,
			PasswordEncoder passwordEncoder,
			String baseUrlCliente,
			int minutosValidez) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
		this.usuariohasRolRepositorio = usuariohasRolRepositorio;
		this.empleadoRepositorio = empleadoRepositorio;
		this.tokenRepositorio = tokenRepositorio;
		this.notificador = notificador;
		this.passwordEncoder = passwordEncoder;
		this.baseUrlCliente = baseUrlCliente;
		this.minutosValidez = minutosValidez;
	}

	@Override
	public String solicitarEnlace(String correoLaboral) {

		Usuario usuario = usuarioAutorizado(correoLaboral);
		Empleado empleado = fichaDelUsuario(usuario);

		String correoPersonal = empleado.getCorreo();
		if (correoPersonal == null || correoPersonal.isBlank()) {
			throw new IllegalStateException(
					"Esa cuenta no tiene un correo personal registrado en su ficha de empleado. "
					+ "Sin ese dato no hay a donde enviar el enlace.");
		}

		invalidarAnteriores(usuario.getIdUsuario());

		String tokenEnClaro = generarToken();

		TokenRecuperacion registro = new TokenRecuperacion();
		registro.setHashToken(huella(tokenEnClaro));
		registro.setFkUsuario(usuario);
		registro.setFechaCreacion(new Date());
		registro.setFechaExpiracion(
				new Date(System.currentTimeMillis() + (long) minutosValidez * 60_000L));
		registro.setUsado(false);
		tokenRepositorio.guardar(registro);

		String enlace = baseUrlCliente + "/recuperar/token/" + tokenEnClaro;
		notificador.enviarEnlaceRecuperacion(
				correoPersonal, usuario.getNombre(), enlace, minutosValidez);

		return enmascarar(correoPersonal);
	}

	@Override
	public void validarToken(String token) {
		tokenVigente(token);
	}

	@Override
	public void restablecerConToken(String token, String nuevaContrasenia) {

		TokenRecuperacion registro = tokenVigente(token);

		if (nuevaContrasenia == null || nuevaContrasenia.trim().length() < LONGITUD_MINIMA_CONTRASENIA) {
			throw new IllegalStateException(
					"La nueva contraseña debe tener al menos " + LONGITUD_MINIMA_CONTRASENIA + " caracteres.");
		}

		Usuario usuario = usuarioRepositorio.buscarPorId(registro.getFkUsuario().getIdUsuario())
				.orElseThrow(() -> new CredencialesInvalidasException(MENSAJE_RECHAZO));

		usuario.setContrasenia(passwordEncoder.encode(nuevaContrasenia.trim()));
		usuarioRepositorio.guardar(usuario);

		registro.setUsado(true);
		tokenRepositorio.guardar(registro);
	}


	private TokenRecuperacion tokenVigente(String token) {
		if (token == null || token.isBlank()) {
			throw new CredencialesInvalidasException("El enlace no es válido.");
		}

		TokenRecuperacion registro = tokenRepositorio.buscarPorHash(huella(token))
				.orElseThrow(() -> new CredencialesInvalidasException(
						"El enlace no es válido. Solicite uno nuevo."));

		if (registro.isUsado()) {
			throw new IllegalStateException(
					"Ese enlace ya se utilizó. Solicite uno nuevo.");
		}

		if (registro.getFechaExpiracion() == null
				|| registro.getFechaExpiracion().before(new Date())) {
			throw new IllegalStateException(
					"El enlace caducó. Solicite uno nuevo.");
		}

		if (registro.getFkUsuario() == null) {
			throw new CredencialesInvalidasException("El enlace no es válido.");
		}

		return registro;
	}

	private void invalidarAnteriores(int idUsuario) {
		List<TokenRecuperacion> vivos = tokenRepositorio.buscarSinUsarPorUsuario(idUsuario);
		for (TokenRecuperacion anterior : vivos) {
			anterior.setUsado(true);
			tokenRepositorio.guardar(anterior);
		}
	}

	private Usuario usuarioAutorizado(String correo) {
		if (correo == null || correo.isBlank()) {
			throw new CredencialesInvalidasException(MENSAJE_RECHAZO);
		}

		Usuario usuario = usuarioRepositorio.buscarPorCorreo(correo.trim())
				.filter(Usuario::isEstadoUsuario)
				.orElseThrow(() -> new CredencialesInvalidasException(MENSAJE_RECHAZO));

		boolean esGerente = usuariohasRolRepositorio.ListarTodos().stream()
				.filter(a -> a.getFkUsuario() != null
						&& a.getFkUsuario().getIdUsuario() == usuario.getIdUsuario())
				.anyMatch(a -> a.getFkRol() != null
						&& a.getFkRol().getNombre() != null
						&& ROL_AUTORIZADO.equalsIgnoreCase(a.getFkRol().getNombre().trim()));

		if (!esGerente) {
			throw new CredencialesInvalidasException(MENSAJE_RECHAZO);
		}
		return usuario;
	}

	
	private Empleado fichaDelUsuario(Usuario usuario) {
		return empleadoRepositorio.ListarTodo().stream()
				.filter(e -> e.getFkUsuario() != null
						&& e.getFkUsuario().getIdUsuario() == usuario.getIdUsuario())
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(
						"Esa cuenta no tiene ficha de empleado, así que no hay un correo "
						+ "personal al que enviar el enlace."));
	}

	private String generarToken() {
		byte[] bytes = new byte[BYTES_DEL_TOKEN];
		aleatorio.nextBytes(bytes);
		// Sin relleno y en alfabeto seguro para URL: el token viaja en la ruta.
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}

	
	private String huella(String token) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return HexFormat.of().formatHex(
					digest.digest(token.trim().getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException ex) {
			throw new IllegalStateException("SHA-256 no disponible en esta JVM", ex);
		}
	}

	private String enmascarar(String correo) {
		int arroba = correo.indexOf('@');
		if (arroba <= 0) {
			return "***";
		}
		return correo.charAt(0) + "***" + correo.substring(arroba);
	}

}
