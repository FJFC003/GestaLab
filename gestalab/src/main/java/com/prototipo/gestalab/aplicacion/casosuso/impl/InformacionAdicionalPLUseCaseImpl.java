package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformacionAdicionalPLUseCase;
import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;
import com.prototipo.gestalab.dominio.repositorio.IInformacionAdicionalPLRepositorio;

public class InformacionAdicionalPLUseCaseImpl implements IInformacionAdicionalPLUseCase{
	
	private final IInformacionAdicionalPLRepositorio repositorio;
	

	public InformacionAdicionalPLUseCaseImpl(IInformacionAdicionalPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public InformacionAdicionalPL guardar(InformacionAdicionalPL nuevoInfoAdi) {
		return repositorio.guardar(nuevoInfoAdi);
	}

	@Override
	public InformacionAdicionalPL buscarPorId(int idInformacion) {
		return repositorio.buscarPorId(idInformacion)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<InformacionAdicionalPL> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idInformacion) {
		repositorio.eliminar(idInformacion);
		
	}

}
