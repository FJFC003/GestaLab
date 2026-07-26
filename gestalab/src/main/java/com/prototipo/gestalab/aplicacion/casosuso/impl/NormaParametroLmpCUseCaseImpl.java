package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.INormaParametroLmpCUseCase;
import com.prototipo.gestalab.dominio.entidades.NormaParametroLmpC;
import com.prototipo.gestalab.dominio.repositorio.INormaParametroLmpCRepositorio;

public class NormaParametroLmpCUseCaseImpl implements INormaParametroLmpCUseCase{
	
	private final INormaParametroLmpCRepositorio repositorio;

	public NormaParametroLmpCUseCaseImpl(INormaParametroLmpCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public NormaParametroLmpC guardar(NormaParametroLmpC nuevo) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevo);
	}

	@Override
	public NormaParametroLmpC buscarPorId(int idNormaParametroLmpC) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idNormaParametroLmpC)
				.orElseThrow(() -> new RuntimeException("No se encontró la asociación Norma-Parámetro-LMP"));
	}

	@Override
	public List<NormaParametroLmpC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public List<NormaParametroLmpC> buscarPorNorma(int idCatalogoNormServi) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorNorma(idCatalogoNormServi);
	}

	@Override
	public void eliminar(int idNormaParametroLmpC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idNormaParametroLmpC);
	}

	

	

}
