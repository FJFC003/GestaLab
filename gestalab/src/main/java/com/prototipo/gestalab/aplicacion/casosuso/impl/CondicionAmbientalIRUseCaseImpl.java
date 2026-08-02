package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICondicionAmbientalIRUseCase;
import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.ICondicionAmbientalIRRepositorio;

public class CondicionAmbientalIRUseCaseImpl implements ICondicionAmbientalIRUseCase{
	
	private final ICondicionAmbientalIRRepositorio repositorio;

	public CondicionAmbientalIRUseCaseImpl(ICondicionAmbientalIRRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CondicionAmbientalIR guardar(CondicionAmbientalIR nuevo) {
		return repositorio.guardar(nuevo);
	}

	@Override
	public CondicionAmbientalIR buscarPorId(int idCondi) {
		return repositorio.buscarPorId(idCondi)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<CondicionAmbientalIR> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idCondi) {
		repositorio.eliminar(idCondi);
	}

	@Override
	public List<CondicionAmbientalIR> listarPorInforme(int idInforme) {
		return repositorio.listarPorInforme(idInforme);
	}

}
