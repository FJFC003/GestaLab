package com.prototipo.gestalab.aplicacion.casosuso.impl;

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
		// TODO Auto-generated method stub
		nuevoUsuario.setContrasenia(passwordEncoder.encode(nuevoUsuario.getContrasenia()));
		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idUsuario)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<Usuario> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idUsuario) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idUsuario);
	}

}
