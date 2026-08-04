package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IEmpleadoRepositorio;

public class EmpleadoUseCaseImpl implements IEmpleadoUseCase{
	
	private final IEmpleadoRepositorio repositorio;

	public EmpleadoUseCaseImpl(IEmpleadoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Empleado guardar(Empleado nuevoEmpleado) {

		if (nuevoEmpleado.getCi() == null || nuevoEmpleado.getCi().isBlank()) {
			throw new IllegalStateException("La cédula del empleado es obligatoria.");
		}

		// Se normaliza antes de comparar y antes de guardar: sin esto, la misma
		// cédula con un espacio al final se toma como distinta y entra dos veces.
		String cedulaLimpia = nuevoEmpleado.getCi().trim();
		nuevoEmpleado.setCi(cedulaLimpia);

		validarFechas(nuevoEmpleado);

		Optional<Empleado> existente = repositorio.ListarTodo().stream()
				.filter(e -> e.getIdEmpleado() != nuevoEmpleado.getIdEmpleado())
				.filter(e -> e.getCi() != null && e.getCi().trim().equalsIgnoreCase(cedulaLimpia))
				.findFirst();

		if (existente.isPresent()) {
			throw new IllegalStateException(
					"Ya existe un empleado registrado con ese número de cédula");
		}

		return repositorio.guardar(nuevoEmpleado);
	}

	/**
	 * Un empleado no puede salir de la empresa antes de haber entrado.
	 *
	 * La fecha de salida vacia es valida: significa que el empleado sigue
	 * trabajando. Solo se comprueba cuando viene informada.
	 */
	private void validarFechas(Empleado empleado) {

		if (empleado.getFechaSalida() == null) {
			return;
		}

		if (empleado.getFechaIngreso() == null) {
			throw new IllegalStateException(
					"No se puede registrar una fecha de salida sin fecha de ingreso.");
		}

		LocalDate ingreso = aDia(empleado.getFechaIngreso());
		LocalDate salida = aDia(empleado.getFechaSalida());

		// Se comparan DIAS, no instantes. La fecha de ingreso se asigna con
		// new Date() y trae hora, mientras que la de salida llega a medianoche
		// desde un input type="date". Comparando instantes, un empleado que
		// entra y sale el mismo dia seria rechazado por error.
		if (salida.isBefore(ingreso)) {
			throw new IllegalStateException(
					"La fecha de salida no puede ser anterior a la fecha de ingreso.");
		}
	}

	/**
	 * Reduce una fecha a su dia calendario.
	 *
	 * Se usa Instant.ofEpochMilli y no fecha.toInstant() porque si el driver
	 * devolviera un java.sql.Date, toInstant() lanza UnsupportedOperationException.
	 */
	private LocalDate aDia(Date fecha) {
		return Instant.ofEpochMilli(fecha.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}

	@Override
	public Empleado buscarPorId(int idEmpleado) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idEmpleado)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<Empleado> ListarTodo() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodo();
	}

	@Override
	public void eliminar(int idEmpleado) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idEmpleado);
	}

}
