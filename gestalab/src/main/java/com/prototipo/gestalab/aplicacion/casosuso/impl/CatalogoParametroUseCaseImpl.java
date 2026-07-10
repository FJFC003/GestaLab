package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoParametroUseCase;
import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoParametroCRepositorio;

public class CatalogoParametroUseCaseImpl implements ICatalogoParametroUseCase{
	
	private final ICatalogoParametroCRepositorio repositorio;

	public CatalogoParametroUseCaseImpl(ICatalogoParametroCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CatalogoParametroC guardar(CatalogoParametroC nuevaCataPara) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaCataPara);
	}

	@Override
	public CatalogoParametroC buscarPorId(int idParametroC) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idParametroC).orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<CatalogoParametroC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idParametroC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idParametroC);
	}

}
