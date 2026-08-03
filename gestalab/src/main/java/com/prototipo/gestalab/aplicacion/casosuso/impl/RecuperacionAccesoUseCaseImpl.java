package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.text.Normalizer;
import java.util.Locale;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecuperacionAccesoUseCase;
import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.dominio.excepciones.CredencialesInvalidasException;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;

public class RecuperacionAccesoUseCaseImpl implements IRecuperacionAccesoUseCase{
	
	private static final String ROL_AUTORIZADO = "Gerente General";

	/** Mismo mensaje para todos los rechazos: no distinguir correo inexistente de rol equivocado. */
	private static final String MENSAJE_RECHAZO =
			"No existe una cuenta de Gerente General activa con ese correo.";

	private static final int LONGITUD_MINIMA_CONTRASENIA = 8;

	private final IUsuarioRepositorio usuarioRepositorio;
	private final IUsuariohasRolRepositorio usuariohasRolRepositorio;
	private final PasswordEncoder passwordEncoder;

	public RecuperacionAccesoUseCaseImpl(IUsuarioRepositorio usuarioRepositorio,
			IUsuariohasRolRepositorio usuariohasRolRepositorio,
			PasswordEncoder passwordEncoder) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
		this.usuariohasRolRepositorio = usuariohasRolRepositorio;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String obtenerPregunta(String correo) {
		Usuario usuario = usuarioAutorizado(correo);

		if (!tieneValor(usuario.getPreguntaSeguridad())) {
			throw new IllegalStateException(
					"Esta cuenta todavia no tiene configurada una pregunta de seguridad. "
					+ "Debe configurarla desde el sistema antes de poder recuperar el acceso.");
		}
		return usuario.getPreguntaSeguridad();
	}

	@Override
	public void restablecerContrasenia(String correo, String respuesta, String nuevaContrasenia) {
		Usuario usuario = usuarioAutorizado(correo);

		if (!tieneValor(usuario.getPreguntaSeguridad()) || !tieneValor(usuario.getRespuestaSeguridad())) {
			throw new IllegalStateException(
					"Esta cuenta no tiene configurada una pregunta de seguridad.");
		}

		if (!tieneValor(nuevaContrasenia) || nuevaContrasenia.trim().length() < LONGITUD_MINIMA_CONTRASENIA) {
			throw new IllegalStateException(
					"La nueva contrasena debe tener al menos " + LONGITUD_MINIMA_CONTRASENIA + " caracteres.");
		}

		if (!passwordEncoder.matches(normalizar(respuesta), usuario.getRespuestaSeguridad())) {
			throw new CredencialesInvalidasException("La respuesta no coincide con la registrada.");
		}

		usuario.setContrasenia(passwordEncoder.encode(nuevaContrasenia.trim()));
		usuarioRepositorio.guardar(usuario);
	}

	@Override
	public void configurarPregunta(int idUsuario, String pregunta, String respuesta) {
		Usuario usuario = usuarioRepositorio.buscarPorId(idUsuario)
				.orElseThrow(() -> new RecursoNoEncontradoException(
						"No existe el usuario con id " + idUsuario));

		if (!esGerenteGeneral(usuario)) {
			throw new IllegalStateException(
					"Solo la cuenta de Gerente General puede configurar una pregunta de seguridad.");
		}

		if (!tieneValor(pregunta)) {
			throw new IllegalStateException("Debe elegir una pregunta de seguridad.");
		}

		String respuestaLimpia = normalizar(respuesta);
		if (respuestaLimpia.length() < 3) {
			throw new IllegalStateException("La respuesta debe tener al menos 3 caracteres.");
		}

		usuario.setPreguntaSeguridad(pregunta.trim());
		usuario.setRespuestaSeguridad(passwordEncoder.encode(respuestaLimpia));
		usuarioRepositorio.guardar(usuario);
	}

	@Override
	public boolean tienePreguntaConfigurada(int idUsuario) {
		return usuarioRepositorio.buscarPorId(idUsuario)
				.map(u -> tieneValor(u.getPreguntaSeguridad()) && tieneValor(u.getRespuestaSeguridad()))
				.orElse(false);
	}

	/**
	 * Localiza al usuario y comprueba que este activo y que sea Gerente General.
	 * Todos los rechazos devuelven el mismo mensaje para no dar pistas.
	 */
	private Usuario usuarioAutorizado(String correo) {
		if (!tieneValor(correo)) {
			throw new CredencialesInvalidasException(MENSAJE_RECHAZO);
		}

		Usuario usuario = usuarioRepositorio.buscarPorCorreo(correo.trim())
				.filter(Usuario::isEstadoUsuario)
				.orElseThrow(() -> new CredencialesInvalidasException(MENSAJE_RECHAZO));

		if (!esGerenteGeneral(usuario)) {
			throw new CredencialesInvalidasException(MENSAJE_RECHAZO);
		}
		return usuario;
	}

	private boolean esGerenteGeneral(Usuario usuario) {
		return usuariohasRolRepositorio.ListarTodos().stream()
				.filter(a -> a.getFkUsuario() != null
						&& a.getFkUsuario().getIdUsuario() == usuario.getIdUsuario())
				.anyMatch(a -> a.getFkRol() != null
						&& a.getFkRol().getNombre() != null
						&& ROL_AUTORIZADO.equalsIgnoreCase(a.getFkRol().getNombre().trim()));
	}

	/**
	 * Deja la respuesta comparable: sin espacios sobrantes, en minusculas y sin
	 * tildes. Asi " Quito ", "QUITO" y "Quito" cuentan como la misma respuesta.
	 * Sin esto, una tilde de mas el dia del apuro deja fuera a la usuaria.
	 */
	private String normalizar(String texto) {
		if (texto == null) {
			return "";
		}
		String sinTildes = Normalizer
				.normalize(texto.trim().toLowerCase(Locale.ROOT), Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return sinTildes.replaceAll("\\s+", " ");
	}

	private boolean tieneValor(String s) {
		return s != null && !s.isBlank();
	}

}
