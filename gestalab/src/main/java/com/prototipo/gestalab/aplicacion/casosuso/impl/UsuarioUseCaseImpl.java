package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase{
	
	private final IUsuarioRepositorio repositorio;

	public UsuarioUseCaseImpl(IUsuarioRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idUsuario)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrado"));
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
