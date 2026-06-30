package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IAreaUseCase;
import com.prototipo.gestalab.dominio.entidades.Area;
import com.prototipo.gestalab.dominio.repositorio.IAreaRepositorio;


public class AreaUseCaseImpl implements IAreaUseCase{
	
	private final IAreaRepositorio repositorio;
	
	public AreaUseCaseImpl(IAreaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Area guardar(Area nuevaArea) {
		return repositorio.guardar(nuevaArea);
	}

	@Override
	public Area buscarPorId(int idArea) {
		return repositorio
				.buscarPorId(idArea)
				.orElseThrow(() -> new RuntimeException("No se encontro los datos"));
	}

	@Override
	public List<Area> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idArea) {
		repositorio.eliminar(idArea);
	}

}
