package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.Date;
import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformeResultadosIRUseCase;
import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.dominio.entidades.EstadoInformeIR;
import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.dominio.entidades.ResultadosIR;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.ICondicionAmbientalIRRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IEquiposUtilizadosIRRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IInformeResultadosIRRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IResultadosIRRepositorio;

import jakarta.transaction.Transactional;

public class InformeResultadosIRUseCaseImpl implements IInformeResultadosIRUseCase{
	
	private final IInformeResultadosIRRepositorio repositorio;
	private final IResultadosIRRepositorio resultadosRepositorio;
	private final ICondicionAmbientalIRRepositorio condicionesRepositorio;
	private final IEquiposUtilizadosIRRepositorio equiposRepositorio;
	
	public InformeResultadosIRUseCaseImpl(IInformeResultadosIRRepositorio repositorio,
			IResultadosIRRepositorio resultadosRepositorio, ICondicionAmbientalIRRepositorio condicionesRepositorio,
			IEquiposUtilizadosIRRepositorio equiposRepositorio) {
		super();
		this.repositorio = repositorio;
		this.resultadosRepositorio = resultadosRepositorio;
		this.condicionesRepositorio = condicionesRepositorio;
		this.equiposRepositorio = equiposRepositorio;
	}

	@Override
	public InformeResultadosIR guardar(InformeResultadosIR nuevoInforme) {
		if (nuevoInforme.getFechaEmisionInforme() == null) {
			nuevoInforme.setFechaEmisionInforme(new Date());
		}
		return repositorio.guardar(nuevoInforme);
	}

	@Override
	public InformeResultadosIR buscarPorId(int idInforme) {
		return repositorio.buscarPorId(idInforme)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<InformeResultadosIR> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idInforme) {
		repositorio.eliminar(idInforme);
	}

	@Override
	public InformeResultadosIR buscarPorOrden(int idOT) {
		return repositorio.buscarPorOrden(idOT).orElse(null);
	}

	@Override
	@Transactional
	public InformeResultadosIR guardarInformeCompleto(InformeResultadosIR informe,
			List<ResultadosIR> resultados,
			List<CondicionAmbientalIR> condiciones,
			List<EquiposUtilizadosIR> equipos) {

		if (informe.getFechaEmisionInforme() == null) {
			informe.setFechaEmisionInforme(new Date());
		}
		if (informe.getEstadoInforme() == null) {
			informe.setEstadoInforme(EstadoInformeIR.EN_ELABORACION);
		}
		InformeResultadosIR guardado = repositorio.guardar(informe);

		InformeResultadosIR referencia = new InformeResultadosIR();
		referencia.setIdInforme(guardado.getIdInforme());

		if (resultados != null) {
			int item = 1;
			for (ResultadosIR r : resultados) {
				if (esVacio(r.getParametros())) {
					continue;
				}
				r.setNoItem(item++);
				r.setFkInforme(referencia);
				resultadosRepositorio.guardar(r);
			}
		}

		if (condiciones != null) {
			for (CondicionAmbientalIR c : condiciones) {
				if (esVacio(c.getNoAlicuota()) && esVacio(c.getHoraToma())
						&& esVacio(c.getTemperatura())) {
					continue;
				}
				c.setFkInforme(referencia);
				condicionesRepositorio.guardar(c);
			}
		}

		if (equipos != null) {
			for (EquiposUtilizadosIR e : equipos) {
				if (esVacio(e.getNombre())) {
					continue;
				}
				e.setFkInforme(referencia);
				equiposRepositorio.guardar(e);
			}
		}

		return guardado;
	}

	/**
	 * El Tecnico de Laboratorio da por terminado el informe y lo pone a
	 * disposicion de la Coordinacion Tecnica, que solo puede consultarlo.
	 */
	@Override
	public InformeResultadosIR enviarACoordinacion(int idInforme) {
		InformeResultadosIR informe = buscarPorId(idInforme);

		if (informe.getEstadoInforme() == EstadoInformeIR.ENVIADO_COORDINACION) {
			throw new IllegalStateException("El informe ya fue enviado a Coordinacion Tecnica");
		}

		informe.setEstadoInforme(EstadoInformeIR.ENVIADO_COORDINACION);
		informe.setFechaEnvioCoordinacion(new Date());
		return repositorio.guardar(informe);
	}

	/** Bandeja de la Coordinacion Tecnica: solo los informes ya enviados. */
	@Override
	public List<InformeResultadosIR> listarEnviados() {
		return repositorio.ListarTodos().stream()
				.filter(i -> i.getEstadoInforme() == EstadoInformeIR.ENVIADO_COORDINACION)
				.toList();
	}

	private boolean esVacio(String s) {
		return s == null || s.isBlank();
	}

}
