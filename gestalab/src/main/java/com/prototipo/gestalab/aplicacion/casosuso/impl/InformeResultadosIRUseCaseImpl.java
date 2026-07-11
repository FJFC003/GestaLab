package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformeResultadosIRUseCase;
import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.dominio.repositorio.IInformeResultadosIRRepositorio;

public class InformeResultadosIRUseCaseImpl implements IInformeResultadosIRUseCase{
	
	private final IInformeResultadosIRRepositorio repositorio;

	public InformeResultadosIRUseCaseImpl(IInformeResultadosIRRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public InformeResultadosIR guardar(InformeResultadosIR nuevoInformeResultadosIR) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoInformeResultadosIR);
	}

	@Override
	public InformeResultadosIR buscarPorId(int idInforme) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idInforme).orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<InformeResultadosIR> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idInforme) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idInforme);
	}

}
