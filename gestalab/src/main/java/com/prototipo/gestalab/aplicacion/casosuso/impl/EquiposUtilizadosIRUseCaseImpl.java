package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEquiposUtilizadosIRUseCase;
import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.dominio.repositorio.IEquiposUtilizadosIRRepositorio;

public class EquiposUtilizadosIRUseCaseImpl implements IEquiposUtilizadosIRUseCase{
	
	private final IEquiposUtilizadosIRRepositorio repositorio;

	public EquiposUtilizadosIRUseCaseImpl(IEquiposUtilizadosIRRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public EquiposUtilizadosIR guardar(EquiposUtilizadosIR nuevoEquiposUtilizadosIR) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoEquiposUtilizadosIR);
	}

	@Override
	public EquiposUtilizadosIR buscarPorId(int idEquipos) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idEquipos).orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<EquiposUtilizadosIR> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idEquipos) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idEquipos);
	}

}
