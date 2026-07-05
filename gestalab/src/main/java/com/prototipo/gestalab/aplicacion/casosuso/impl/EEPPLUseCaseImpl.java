package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEEPPLUseCase;
import com.prototipo.gestalab.dominio.entidades.EEPPL;
import com.prototipo.gestalab.dominio.repositorio.IEEPPLRepositorio;

public class EEPPLUseCaseImpl implements IEEPPLUseCase{
	
	private final IEEPPLRepositorio repositorio;
	
	

	public EEPPLUseCaseImpl(IEEPPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public EEPPL guardar(EEPPL nuevoEEPPL) {
		return repositorio.guardar(nuevoEEPPL);
	}

	@Override
	public EEPPL buscarPorId(int idEEP) {
		return repositorio.buscarPorId(idEEP)
				.orElseThrow(() -> new RuntimeException("no se encontro informacion"));
	}

	@Override
	public List<EEPPL> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idEEP) {
		repositorio.eliminar(idEEP);
	}

}
