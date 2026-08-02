package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEquiposUtilizadosIRUseCase;
import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IEquiposUtilizadosIRRepositorio;

public class EquiposUtilizadosIRUseCaseImpl implements IEquiposUtilizadosIRUseCase{
	
	private final IEquiposUtilizadosIRRepositorio repositorio;

	public EquiposUtilizadosIRUseCaseImpl(IEquiposUtilizadosIRRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public EquiposUtilizadosIR guardar(EquiposUtilizadosIR nuevo) {
		return repositorio.guardar(nuevo);
	}

	@Override
	public EquiposUtilizadosIR buscarPorId(int idEquipos) {
		return repositorio.buscarPorId(idEquipos)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<EquiposUtilizadosIR> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idEquipos) {
		repositorio.eliminar(idEquipos);
	}

	@Override
	public List<EquiposUtilizadosIR> listarPorInforme(int idInforme) {
		return repositorio.listarPorInforme(idInforme);
	}

}
