package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IResultadosIRUseCase;
import com.prototipo.gestalab.dominio.entidades.ResultadosIR;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IResultadosIRRepositorio;

public class ResultadosIRUseCaseImpl implements IResultadosIRUseCase{
	
	private final IResultadosIRRepositorio repositorio;

	public ResultadosIRUseCaseImpl(IResultadosIRRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public ResultadosIR guardar(ResultadosIR nuevo) {
		return repositorio.guardar(nuevo);
	}

	@Override
	public ResultadosIR buscarPorId(int idResultados) {
		return repositorio.buscarPorId(idResultados)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<ResultadosIR> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idResultados) {
		repositorio.eliminar(idResultados);
	}

	@Override
	public List<ResultadosIR> listarPorInforme(int idInforme) {
		return repositorio.listarPorInforme(idInforme);
	}
	
	

}
