package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRolUseCase;
import com.prototipo.gestalab.dominio.entidades.Rol;
import com.prototipo.gestalab.dominio.repositorio.IRolRepositorio;

public class RolUseCaseImpl implements IRolUseCase{
	
	private final IRolRepositorio repositorio;

	public RolUseCaseImpl(IRolRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Rol guardar(Rol nuevoRol) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoRol);
	}

	@Override
	public Rol buscarPorId(int idRol) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idRol)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrado"));
	}

	@Override
	public List<Rol> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idRol) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idRol);
	}
	
	

}
