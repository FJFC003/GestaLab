package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDatosLaboratorioIRUseCase;
import com.prototipo.gestalab.dominio.entidades.DatosLaboratorioIR;
import com.prototipo.gestalab.dominio.repositorio.IDatosLaboratorioIRRepositorio;

public class DatosLaboratorioIRUseCaseImpl implements IDatosLaboratorioIRUseCase{
	
	private final IDatosLaboratorioIRRepositorio repositorio;

	public DatosLaboratorioIRUseCaseImpl(IDatosLaboratorioIRRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public DatosLaboratorioIR guardar(DatosLaboratorioIR nuevoDatosLaboratorioIR) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoDatosLaboratorioIR);
	}

	@Override
	public DatosLaboratorioIR buscarPorId(int idDatos) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idDatos).orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<DatosLaboratorioIR> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idDatos) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idDatos);
	}

}
