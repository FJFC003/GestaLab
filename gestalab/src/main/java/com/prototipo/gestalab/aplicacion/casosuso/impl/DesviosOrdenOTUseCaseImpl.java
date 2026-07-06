package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDesviosOrdenOTUseCase;
import com.prototipo.gestalab.dominio.entidades.DesviosOrdenOT;
import com.prototipo.gestalab.dominio.repositorio.IDesviosOrdenOTRepositorio;

public class DesviosOrdenOTUseCaseImpl implements IDesviosOrdenOTUseCase{

	private final IDesviosOrdenOTRepositorio repositorio;
	
	
	
	public DesviosOrdenOTUseCaseImpl(IDesviosOrdenOTRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public DesviosOrdenOT guardar(DesviosOrdenOT nuevaDesvioOrdenOT) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaDesvioOrdenOT);
	}

	@Override
	public DesviosOrdenOT buscarPorId(int idDesviosOrdenOT) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idDesviosOrdenOT)
				.orElseThrow(() -> new RuntimeException("Informacion no enconrada"));
	}

	@Override
	public List<DesviosOrdenOT> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idDesviosOrdenOT) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idDesviosOrdenOT);
	}

}
