package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IPlanMuestreoPLUseCase;
import com.prototipo.gestalab.dominio.entidades.EstadoPlanMuestreo;
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

		// La identificacion la genera el sistema y no puede repetirse.
		if (nuevoPlan.getCodigoPlan() == null || nuevoPlan.getCodigoPlan().isBlank()) {
			nuevoPlan.setCodigoPlan(generarCodigoPlan());
		} else {
			validarCodigoUnico(nuevoPlan);
		}

		if (nuevoPlan.getFechaElaboracion() == null) {
			nuevoPlan.setFechaElaboracion(new Date());
		}

		return repositorio.guardar(nuevoPlan);
	}

	/**
	 * Genera identificaciones del tipo PM-2026-0007. Toma el numero mas alto que
	 * ya existe para el anio en curso y suma uno; si el resultado ya estuviera
	 * ocupado, sigue avanzando hasta encontrar uno libre.
	 */
	private String generarCodigoPlan() {
		int anio = Calendar.getInstance().get(Calendar.YEAR);
		String prefijo = "PM-" + anio + "-";

		List<PlanMuestreoPL> existentes = repositorio.ListarTodos();

		int mayor = 0;
		for (PlanMuestreoPL plan : existentes) {
			String codigo = plan.getCodigoPlan();
			if (codigo != null && codigo.startsWith(prefijo)) {
				try {
					mayor = Math.max(mayor, Integer.parseInt(codigo.substring(prefijo.length())));
				} catch (NumberFormatException ignorado) {
					// Un codigo con otro formato no participa en la numeracion.
				}
			}
		}

		String candidato;
		do {
			mayor++;
			candidato = prefijo + String.format("%04d", mayor);
		} while (codigoOcupado(existentes, candidato, 0));

		return candidato;
	}

	private void validarCodigoUnico(PlanMuestreoPL plan) {
		if (codigoOcupado(repositorio.ListarTodos(), plan.getCodigoPlan().trim(), plan.getIdPlan())) {
			throw new IllegalStateException(
					"Ya existe un plan con la identificacion \"" + plan.getCodigoPlan().trim() + "\".");
		}
	}

	private boolean codigoOcupado(List<PlanMuestreoPL> planes, String codigo, int idPropio) {
		return planes.stream()
				.filter(plan -> plan.getIdPlan() != idPropio)
				.anyMatch(plan -> plan.getCodigoPlan() != null
						&& plan.getCodigoPlan().trim().equalsIgnoreCase(codigo));
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

	@Override
	public PlanMuestreoPL enviarATecnico(int idPlan) {
		// TODO Auto-generated method stub
		PlanMuestreoPL plan = buscarPorId(idPlan);

		if (plan.getEstadoPlan() == EstadoPlanMuestreo.ENVIADO) {
			throw new IllegalStateException("El plan ya fue enviado al Técnico de Campo");
		}

		plan.setEstadoPlan(EstadoPlanMuestreo.ENVIADO);
		plan.setFechaEnvioTecnico(new Date());
		return repositorio.guardar(plan);
	}

	@Override
	public PlanMuestreoPL devolverAElaboracion(int idPlan) {
		// TODO Auto-generated method stub
		PlanMuestreoPL plan = buscarPorId(idPlan);
		plan.setEstadoPlan(EstadoPlanMuestreo.EN_ELABORACION);
		plan.setFechaEnvioTecnico(null);
		return repositorio.guardar(plan);
	}

	@Override
	public PlanMuestreoPL marcarCompletado(int idPlan) {
		// TODO Auto-generated method stub
		PlanMuestreoPL plan = buscarPorId(idPlan);

		if (plan.getEstadoPlan() != EstadoPlanMuestreo.ENVIADO) {
			throw new IllegalStateException("Solo se puede completar un plan que fue enviado al técnico");
		}

		plan.setEstadoPlan(EstadoPlanMuestreo.COMPLETADO);
		return repositorio.guardar(plan);
	}

}
