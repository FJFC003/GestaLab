package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase{
	
	private final IUsuarioRepositorio repositorio;
	private final PasswordEncoder passwordEncoder;

	public UsuarioUseCaseImpl(IUsuarioRepositorio repositorio, PasswordEncoder passwordEncoder) {
		super();
		this.repositorio = repositorio;
		this.passwordEncoder = passwordEncoder;
	}

	
	@Override
	public Usuario guardar(Usuario nuevoUsuario) {

		if (nuevoUsuario.getIdUsuario() <= 0) {
			validarCorreoDisponible(nuevoUsuario.getCorreo(), 0);

			nuevoUsuario.setContrasenia(passwordEncoder.encode(nuevoUsuario.getContrasenia()));
			if (nuevoUsuario.getFechaCreacion() == null) {
				nuevoUsuario.setFechaCreacion(new Date());
			}
			return repositorio.guardar(nuevoUsuario);
		}

		
		Usuario existente = repositorio.buscarPorId(nuevoUsuario.getIdUsuario())
				.orElseThrow(() -> new RecursoNoEncontradoException(
						"No existe el usuario con id " + nuevoUsuario.getIdUsuario()));

		if (tieneValor(nuevoUsuario.getCorreo())
				&& !nuevoUsuario.getCorreo().equalsIgnoreCase(existente.getCorreo())) {
			validarCorreoDisponible(nuevoUsuario.getCorreo(), existente.getIdUsuario());
			existente.setCorreo(nuevoUsuario.getCorreo());
		}

		if (tieneValor(nuevoUsuario.getNombre())) {
			existente.setNombre(nuevoUsuario.getNombre());
		}

		existente.setEstadoUsuario(nuevoUsuario.isEstadoUsuario());

		
		if (esContraseniaNueva(nuevoUsuario.getContrasenia(), existente.getContrasenia())) {
			existente.setContrasenia(passwordEncoder.encode(nuevoUsuario.getContrasenia()));
		}

		return repositorio.guardar(existente);
	}

	
	private boolean esContraseniaNueva(String recibida, String actual) {
		if (!tieneValor(recibida)) {
			return false;
		}
		if (recibida.equals(actual)) {
			return false;   
		}
		return !pareceHashBCrypt(recibida);
	}

	private boolean pareceHashBCrypt(String valor) {
		return valor != null && valor.length() == 60
				&& (valor.startsWith("$2a$") || valor.startsWith("$2b$") || valor.startsWith("$2y$"));
	}

	private void validarCorreoDisponible(String correo, int idQueSeEstaEditando) {
		if (!tieneValor(correo)) {
			return;
		}
		repositorio.buscarPorCorreo(correo).ifPresent(otro -> {
			if (otro.getIdUsuario() != idQueSeEstaEditando) {
				throw new IllegalStateException(
						"Ya existe un usuario registrado con el correo " + correo);
			}
		});
	}

	private boolean tieneValor(String s) {
		return s != null && !s.isBlank();
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		return repositorio.buscarPorId(idUsuario)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<Usuario> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idUsuario) {
		repositorio.eliminar(idUsuario);
	}

	
	@Override
	public Usuario cambiarContrasenia(int idUsuario, String contraseniaEnClaro) {
		if (!tieneValor(contraseniaEnClaro)) {
			throw new IllegalStateException("La contraseña no puede estar vacía");
		}

		Usuario existente = repositorio.buscarPorId(idUsuario)
				.orElseThrow(() -> new RecursoNoEncontradoException(
						"No existe el usuario con id " + idUsuario));

		existente.setContrasenia(passwordEncoder.encode(contraseniaEnClaro));
		return repositorio.guardar(existente);
	}

}
