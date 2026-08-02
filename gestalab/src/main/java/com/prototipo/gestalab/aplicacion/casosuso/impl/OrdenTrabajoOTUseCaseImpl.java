package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.Date;
import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IOrdenTrabajoOTUseCase;
import com.prototipo.gestalab.dominio.entidades.EstadoOrdenTrabajo;
import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IOrdenTrabajoOTRepositorio;

public class OrdenTrabajoOTUseCaseImpl implements IOrdenTrabajoOTUseCase{
	
	private final  IOrdenTrabajoOTRepositorio repositorio;
	
	

	public OrdenTrabajoOTUseCaseImpl(IOrdenTrabajoOTRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public OrdenTrabajoOT guardar(OrdenTrabajoOT nuevaOrdenTrabajoOT) {
		if (nuevaOrdenTrabajoOT.getEstadoOT() == null) {
			nuevaOrdenTrabajoOT.setEstadoOT(EstadoOrdenTrabajo.EN_EJECUCION);
		}
		return repositorio.guardar(nuevaOrdenTrabajoOT);
	}

	@Override
	public OrdenTrabajoOT buscarPorId(int idOT) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idOT)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<OrdenTrabajoOT> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idOt) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idOt);
	}

	@Override
	public List<OrdenTrabajoOT> listarPorTecnico(int idEmpleado) {
		// TODO Auto-generated method stub
		return repositorio.listarPorTecnico(idEmpleado);
	}

	@Override
	public List<OrdenTrabajoOT> listarPorPlan(int idPlan) {
		// TODO Auto-generated method stub
		return repositorio.listarPorPlan(idPlan);
	}

	
	@Override
	public OrdenTrabajoOT enviarALaboratorio(int idOT) {
		OrdenTrabajoOT orden = buscarPorId(idOT);

		if (orden.getEstadoOT() == EstadoOrdenTrabajo.ENVIADA_LABORATORIO) {
			throw new IllegalStateException("La orden ya fue enviada al Laboratorio");
		}
		if (orden.getEstadoOT() == EstadoOrdenTrabajo.INFORME_EMITIDO) {
			throw new IllegalStateException("La orden ya tiene un informe de resultados emitido");
		}

		orden.setEstadoOT(EstadoOrdenTrabajo.ENVIADA_LABORATORIO);
		orden.setFechaEnvioLaboratorio(new Date());

		if (orden.getFechaCierreCampoOT() == null) {
			orden.setFechaCierreCampoOT(new Date());
		}

		return repositorio.guardar(orden);
	}

	
	@Override
	public OrdenTrabajoOT devolverACoordinacion(int idOT) {
		OrdenTrabajoOT orden = buscarPorId(idOT);

		if (orden.getEstadoOT() == EstadoOrdenTrabajo.INFORME_EMITIDO) {
			throw new IllegalStateException("No se puede devolver una orden que ya tiene informe emitido");
		}

		orden.setEstadoOT(EstadoOrdenTrabajo.EN_EJECUCION);
		orden.setFechaEnvioLaboratorio(null);
		return repositorio.guardar(orden);
	}

	
	@Override
	public List<OrdenTrabajoOT> listarParaLaboratorio() {
		return repositorio.ListarTodos().stream()
				.filter(o -> o.getEstadoOT() == EstadoOrdenTrabajo.ENVIADA_LABORATORIO)
				.toList();
	}

}
