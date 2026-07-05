package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IParametroAnalizarPLUseCase;
import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;
import com.prototipo.gestalab.dominio.repositorio.IParametroAnalizarPLRepositorio;

public class ParametroAnalizarPLUseCaseImpl implements IParametroAnalizarPLUseCase{
	
	private final IParametroAnalizarPLRepositorio repositorio;
	
	

	public ParametroAnalizarPLUseCaseImpl(IParametroAnalizarPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public ParametroAnalizarPL guardar(ParametroAnalizarPL nuevoParameAnali) {
		return repositorio.guardar(nuevoParameAnali);
	}

	@Override
	public ParametroAnalizarPL buscarPorId(int idParametroPL) {
		return repositorio.buscarPorId(idParametroPL)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<ParametroAnalizarPL> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idParametroPL) {
		repositorio.eliminar(idParametroPL);
		
	}

}
