package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ILoginUseCase;
import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.dominio.excepciones.CredencialesInvalidasException;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;


public class LoginUseCaseImpl implements ILoginUseCase{

	private final IUsuarioRepositorio usuarioRepositorio;
	private final PasswordEncoder passwordEncoder;

	public LoginUseCaseImpl(IUsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Usuario autenticar(String correo, String contrasenia) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepositorio.buscarPorCorreo(correo)
	            .filter(Usuario::isEstadoUsuario)
	            .orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));

	    if (!passwordEncoder.matches(contrasenia, usuario.getContrasenia())) {
	        throw new CredencialesInvalidasException("Correo o contraseña incorrectos");
	    }
	    return usuario;
	}

	
}
