package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformacionMatrizPLUseCase;
import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;
import com.prototipo.gestalab.dominio.repositorio.IInformacionMatrizPLRepositorio;

public class InformacionMatrizPLUseCaseImpl implements IInformacionMatrizPLUseCase{
	
	private final IInformacionMatrizPLRepositorio repositorio;
	
	

	public InformacionMatrizPLUseCaseImpl(IInformacionMatrizPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public InformacionMatrizPL guardar(InformacionMatrizPL nuevoInfoMatriz) {
		return repositorio.guardar(nuevoInfoMatriz);
	}

	@Override
	public InformacionMatrizPL buscarPorId(int idInfoMatriz) {
		return repositorio.buscarPorId(idInfoMatriz)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<InformacionMatrizPL> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idInfoMatriz) {
		repositorio.eliminar(idInfoMatriz);
		
	}

}
