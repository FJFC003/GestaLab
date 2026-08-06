package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.Date;
import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICotizacionCUseCase;
import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.dominio.entidades.EstadoAprobacionCotizacion;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.ICotizacionCRepositorio;

public class CotizacionCUseCaseImpl implements ICotizacionCUseCase{
	
	private final ICotizacionCRepositorio repositorio;
	


	public CotizacionCUseCaseImpl(ICotizacionCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CotizacionC guardar(CotizacionC nuevaCotizacion) {

		// Solo en actualizaciones: una cotizacion ya existente tiene id.
		if (nuevaCotizacion.getIdCotizacionC() > 0) {

			CotizacionC existente = buscarPorId(nuevaCotizacion.getIdCotizacionC());

			// Una cotizacion aprobada es un compromiso con el cliente y la base
			// de la que cuelga el Plan de Muestreo. No se toca.
			if (existente.getEstadoAprobacion() == EstadoAprobacionCotizacion.APROBADA) {
				throw new IllegalStateException(
						"Esta cotización ya fue aprobada y no se puede modificar.");
			}

			// El formulario de edicion NO envia los datos de aprobacion, asi que
			// llegan en null. Sin esto, guardar una cotizacion ENVIADA o PAGADA
			// la devolveria a BORRADOR y borraria quien la aprobo y cuando.
			if (nuevaCotizacion.getEstadoAprobacion() == null) {
				nuevaCotizacion.setEstadoAprobacion(existente.getEstadoAprobacion());
			}
			if (nuevaCotizacion.getFechaAprobacionCotizacionC() == null) {
				nuevaCotizacion.setFechaAprobacionCotizacionC(existente.getFechaAprobacionCotizacionC());
			}
			if (nuevaCotizacion.getFkEmpleadoAprueba() == null) {
				nuevaCotizacion.setFkEmpleadoAprueba(existente.getFkEmpleadoAprueba());
			}
			if (nuevaCotizacion.getFechaPagoCotizacionC() == null) {
				nuevaCotizacion.setFechaPagoCotizacionC(existente.getFechaPagoCotizacionC());
			}
			if (nuevaCotizacion.getFechaEnvioCotizacionC() == null) {
				nuevaCotizacion.setFechaEnvioCotizacionC(existente.getFechaEnvioCotizacionC());
			}
			if (nuevaCotizacion.getFechaLimitePagoCotizacionC() == null) {
				nuevaCotizacion.setFechaLimitePagoCotizacionC(existente.getFechaLimitePagoCotizacionC());
			}
		}

		// Cotizacion nueva sin estado: nace como borrador.
		if (nuevaCotizacion.getEstadoAprobacion() == null) {
			nuevaCotizacion.setEstadoAprobacion(EstadoAprobacionCotizacion.BORRADOR);
		}

		return repositorio.guardar(nuevaCotizacion);
	}

	@Override
	public CotizacionC buscarPorId(int idCotizacionC) {
		// TODO Auto-generated method stub
		return repositorio
				.buscarPorId(idCotizacionC)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<CotizacionC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idCotizacionC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idCotizacionC);
	}

	@Override
	public CotizacionC aprobar(int idCotizacionC, int idEmpleadoAprueba, Date fechaPago) {
		// TODO Auto-generated method stub
		CotizacionC cotizacion = buscarPorId(idCotizacionC);

		EstadoAprobacionCotizacion estado = cotizacion.getEstadoAprobacion();
		if (estado == EstadoAprobacionCotizacion.APROBADA) {
			throw new IllegalStateException("La cotización ya fue aprobada");
		}
		if (estado == EstadoAprobacionCotizacion.RECHAZADA
				|| estado == EstadoAprobacionCotizacion.VENCIDA) {
			throw new IllegalStateException("No se puede aprobar una cotización rechazada o vencida");
		}

		Empleado aprobador = new Empleado();
		aprobador.setIdEmpleado(idEmpleadoAprueba);

		cotizacion.setFkEmpleadoAprueba(aprobador);
		cotizacion.setFechaPagoCotizacionC(fechaPago);
		cotizacion.setFechaAprobacionCotizacionC(new Date());
		cotizacion.setEstadoAprobacion(EstadoAprobacionCotizacion.APROBADA);

		// Se llama al repositorio directamente, no a guardar(), para que la
		// validacion "no se modifica una aprobada" no bloquee la aprobacion.
		return repositorio.guardar(cotizacion);
	}

	@Override
	public CotizacionC rechazar(int idCotizacionC) {
		// TODO Auto-generated method stub
		CotizacionC cotizacion = buscarPorId(idCotizacionC);
		if (cotizacion.getEstadoAprobacion() == EstadoAprobacionCotizacion.APROBADA) {
			throw new IllegalStateException("No se puede rechazar una cotización ya aprobada");
		}
		cotizacion.setEstadoAprobacion(EstadoAprobacionCotizacion.RECHAZADA);
		return repositorio.guardar(cotizacion);
	}
}
