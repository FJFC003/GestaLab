package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoTerminoCondiCUseCase;
import com.prototipo.gestalab.dominio.entidades.CatalogoTerminoCondiC;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoTerminoCondiCRepositorio;

public class CatalogoTerminoCondiCUseCaseImpl implements ICatalogoTerminoCondiCUseCase{
	
	private final ICatalogoTerminoCondiCRepositorio repositorio;

	public CatalogoTerminoCondiCUseCaseImpl(ICatalogoTerminoCondiCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CatalogoTerminoCondiC guardar(CatalogoTerminoCondiC nuevaTerminoCondi) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaTerminoCondi);
	}

	@Override
	public CatalogoTerminoCondiC buscarPorId(int idTerminoC) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idTerminoC).orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<CatalogoTerminoCondiC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idTerminoC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idTerminoC);
	}

	

}
