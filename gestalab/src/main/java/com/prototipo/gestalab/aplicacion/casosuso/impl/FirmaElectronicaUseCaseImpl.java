package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IFirmaElectronicaUseCase;
import com.prototipo.gestalab.dominio.entidades.FirmaElectronica;
import com.prototipo.gestalab.dominio.repositorio.IFirmaElectronicaRepositorio;

public class FirmaElectronicaUseCaseImpl implements IFirmaElectronicaUseCase{
	
	private final IFirmaElectronicaRepositorio repositorio;

	public FirmaElectronicaUseCaseImpl(IFirmaElectronicaRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public FirmaElectronica guardar(FirmaElectronica nuevaFirma) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaFirma);
	}

	@Override
	public FirmaElectronica buscarPorId(int idFirma) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idFirma)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrado"));
	}

	@Override
	public List<FirmaElectronica> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idFirma) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idFirma);
	}

}
