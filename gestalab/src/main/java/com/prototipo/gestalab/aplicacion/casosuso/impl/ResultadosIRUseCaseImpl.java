package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IResultadosIRUseCase;
import com.prototipo.gestalab.dominio.entidades.ResultadosIR;
import com.prototipo.gestalab.dominio.repositorio.IResultadosIRRepositorio;

public class ResultadosIRUseCaseImpl implements IResultadosIRUseCase{
	
	private final IResultadosIRRepositorio repositorio;

	public ResultadosIRUseCaseImpl(IResultadosIRRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public ResultadosIR guardar(ResultadosIR nuevoResultadosIR) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoResultadosIR);
	}

	@Override
	public ResultadosIR buscarPorId(int idResultados) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idResultados).orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<ResultadosIR> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idResultados) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idResultados);
	}
	
	

}
