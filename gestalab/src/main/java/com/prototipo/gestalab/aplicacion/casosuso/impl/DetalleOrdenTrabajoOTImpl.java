package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDetalleOrdenTrabajoOTUseCase;
import com.prototipo.gestalab.dominio.entidades.DetalleOrdenTrabajoOT;
import com.prototipo.gestalab.dominio.repositorio.IDetalleOrdenTrabajoOTRepositorio;

public class DetalleOrdenTrabajoOTImpl implements IDetalleOrdenTrabajoOTUseCase{
	
	private final IDetalleOrdenTrabajoOTRepositorio repositorio;
	
	

	public DetalleOrdenTrabajoOTImpl(IDetalleOrdenTrabajoOTRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public DetalleOrdenTrabajoOT guardar(DetalleOrdenTrabajoOT nuevaDesvioOrdenOT) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaDesvioOrdenOT);
	}

	@Override
	public DetalleOrdenTrabajoOT buscarPorId(int idDetalleOrdenOT) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idDetalleOrdenOT)
				.orElseThrow(() -> new RuntimeException("Informacion no enconrada"));
	}

	@Override
	public List<DetalleOrdenTrabajoOT> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idDetalleOrdenOT) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idDetalleOrdenOT);
	}

}
