package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ILoginUseCase;
import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;


public class LoginUseCaseImpl {

	private final IUsuarioRepositorio usuarioRepositorio;

	public LoginUseCaseImpl(IUsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	Usuario autenticar(String correo, String contrasenia);
	List<Usuario> usuarios = usuarioRepositorio.ListarTodos();

		Optional<Usuario> encontrado = usuarios.stream()
				.filter(u -> u.getCorreo() != null && u.getCorreo().equalsIgnoreCase(correo))
				.filter(u -> u.getContrasenia() != null && u.getContrasenia().equals(contrasenia))
				.filter(Usuario::isEstadoUsuario)
				.findFirst();

		return encontrado.orElseThrow(() -> new IllegalStateException("Correo o contraseña incorrectos"));
	}
}
