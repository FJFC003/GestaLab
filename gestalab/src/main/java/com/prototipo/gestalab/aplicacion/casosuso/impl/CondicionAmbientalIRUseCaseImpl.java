package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICondicionAmbientalIRUseCase;
import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.dominio.repositorio.ICondicionAmbientalIRRepositorio;

public class CondicionAmbientalIRUseCaseImpl implements ICondicionAmbientalIRUseCase{
	
	private final ICondicionAmbientalIRRepositorio repositorio;

	public CondicionAmbientalIRUseCaseImpl(ICondicionAmbientalIRRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CondicionAmbientalIR guardar(CondicionAmbientalIR nuevoCondicionAmbientalIR) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoCondicionAmbientalIR);
	}

	@Override
	public CondicionAmbientalIR buscarPorId(int idCondi) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idCondi).orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<CondicionAmbientalIR> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idCondi) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idCondi);
	}

}
