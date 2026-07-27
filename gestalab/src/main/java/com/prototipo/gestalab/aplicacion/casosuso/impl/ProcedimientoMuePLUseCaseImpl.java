package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IProcedimientoMuePLUseCase;
import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IProcedimientoMuePLRepositorio;

public class ProcedimientoMuePLUseCaseImpl implements IProcedimientoMuePLUseCase{
	
	private final IProcedimientoMuePLRepositorio repositorio;

	public ProcedimientoMuePLUseCaseImpl(IProcedimientoMuePLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public ProcedimientoMuePL guardar(ProcedimientoMuePL nuevoProMue) {
		return repositorio.guardar(nuevoProMue);
	}

	@Override
	public ProcedimientoMuePL buscarPorId(int idProcedimiento) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idProcedimiento)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<ProcedimientoMuePL> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idProcedimiento) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idProcedimiento);
	}

	@Override
	public List<ProcedimientoMuePL> listarPorPlan(int idPlan) {
		// TODO Auto-generated method stub
		return repositorio.listarPorPlan(idPlan);
	}

}
