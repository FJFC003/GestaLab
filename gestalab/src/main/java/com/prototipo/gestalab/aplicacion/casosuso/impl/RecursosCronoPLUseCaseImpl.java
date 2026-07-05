package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecursosCronoPLUseCase;
import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;
import com.prototipo.gestalab.dominio.repositorio.IRecursosCronoPLRepositorio;

public class RecursosCronoPLUseCaseImpl implements IRecursosCronoPLUseCase{
	
	private final IRecursosCronoPLRepositorio repositorio;

	public RecursosCronoPLUseCaseImpl(IRecursosCronoPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public RecursosCronoPL guardar(RecursosCronoPL nuevoRecursosCronoPL) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoRecursosCronoPL);
	}

	@Override
	public RecursosCronoPL buscarPorId(int idRecursos) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idRecursos)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<RecursosCronoPL> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idRecursos) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idRecursos);
	}

}
