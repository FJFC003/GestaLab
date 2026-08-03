package com.prototipo.gestalab.aplicacion.casosuso.impl;

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
