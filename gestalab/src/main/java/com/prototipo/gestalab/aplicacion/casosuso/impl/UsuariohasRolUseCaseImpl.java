package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuariohasRolUseCase;
import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;

public class UsuariohasRolUseCaseImpl implements IUsuariohasRolUseCase{
	
	private final IUsuariohasRolRepositorio repositorio;

	public UsuariohasRolUseCaseImpl(IUsuariohasRolRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public UsuariohasRol guardar(UsuariohasRol nuevoUsuariohasRol) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoUsuariohasRol);
	}

	@Override
	public UsuariohasRol buscarPorId(int idUsuarioRol) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idUsuarioRol)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrado"));
	}

	@Override
	public List<UsuariohasRol> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idUsuarioRol) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idUsuarioRol);
	}

}
