package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.dominio.repositorio.IEmpleadoRepositorio;

public class EmpleadoUseCaseImpl implements IEmpleadoUseCase{
	
	private final IEmpleadoRepositorio repositorio;

	public EmpleadoUseCaseImpl(IEmpleadoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Empleado guardar(Empleado nuevoEmpleado) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoEmpleado);
	}

	@Override
	public Empleado buscarPorId(int idEmpleado) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idEmpleado)
				.orElseThrow(() -> new RuntimeException("Informacion no se encontro"));
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
