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
		
				if (nuevoPlan.getFkeep() != null && nuevoPlan.getFkeep().getIdEEP() <= 0) {
					nuevoPlan.setFkeep(null);
				}
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

	@Override
	public List<PlanMuestreoPL> listarPorDetalle(int idDetalleC) {
		// TODO Auto-generated method stub
		return repositorio.listarPorDetalle(idDetalleC);
	}

	@Override
	public List<PlanMuestreoPL> listarPorCotizacion(int idCotizacionC) {
		// TODO Auto-generated method stub
		return repositorio.listarPorCotizacion(idCotizacionC);
	}

	@Override
	public List<PlanMuestreoPL> listarPorResponsable(int idEmpleado) {
		// TODO Auto-generated method stub
		return repositorio.listarPorResponsable(idEmpleado);
	}

}
