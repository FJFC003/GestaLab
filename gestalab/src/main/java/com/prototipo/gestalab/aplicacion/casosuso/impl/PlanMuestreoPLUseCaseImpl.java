package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IPlanMuestreoPLUseCase;
import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IPlanMuestreoPLRepositorio;

public class PlanMuestreoPLUseCaseImpl implements IPlanMuestreoPLUseCase{
	
	private final IPlanMuestreoPLRepositorio repositorio;

	public PlanMuestreoPLUseCaseImpl(IPlanMuestreoPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public PlanMuestreoPL guardar(PlanMuestreoPL nuevoPlan) {
		return repositorio.guardar(nuevoPlan);
	}

	@Override
	public PlanMuestreoPL buscarPorId(int idPlan) {
	return repositorio.buscarPorId(idPlan)
			.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<PlanMuestreoPL> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idPlan) {
		repositorio.eliminar(idPlan);
		
	}

}
