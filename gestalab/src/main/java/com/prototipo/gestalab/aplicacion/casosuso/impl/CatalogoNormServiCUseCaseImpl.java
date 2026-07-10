package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoNormServiCUseCase;
import com.prototipo.gestalab.dominio.entidades.CatalogoNormServiC;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoNormServiCRepositorio;

public class CatalogoNormServiCUseCaseImpl implements ICatalogoNormServiCUseCase{
	
	private ICatalogoNormServiCRepositorio repositorio;

	public CatalogoNormServiCUseCaseImpl(ICatalogoNormServiCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CatalogoNormServiC guardar(CatalogoNormServiC nuevoCatalogoNorm) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoCatalogoNorm);
	}

	@Override
	public CatalogoNormServiC buscarPorId(int idCatalogoNormServi) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idCatalogoNormServi).orElseThrow(() -> new RuntimeException("Informacion no encontreda"));
	}

	@Override
	public List<CatalogoNormServiC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idCatalogoNormServi) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idCatalogoNormServi);
	}

}
