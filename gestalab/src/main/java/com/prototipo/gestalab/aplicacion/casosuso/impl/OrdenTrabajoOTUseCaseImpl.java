package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IOrdenTrabajoOTUseCase;
import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;
import com.prototipo.gestalab.dominio.repositorio.IOrdenTrabajoOTRepositorio;

public class OrdenTrabajoOTUseCaseImpl implements IOrdenTrabajoOTUseCase{
	
	private final  IOrdenTrabajoOTRepositorio repositorio;
	
	

	public OrdenTrabajoOTUseCaseImpl(IOrdenTrabajoOTRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public OrdenTrabajoOT guardar(OrdenTrabajoOT nuevaOrdenTrabajoOT) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaOrdenTrabajoOT);
	}

	@Override
	public OrdenTrabajoOT buscarPorId(int idOT) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idOT)
				.orElseThrow(()->new RuntimeException("Informacion no enconrada"));
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

}
