package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICotizacionCUseCase;
import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.dominio.repositorio.ICotizacionCRepositorio;

public class CotizacionCUseCaseImpl implements ICotizacionCUseCase{
	
	private final ICotizacionCRepositorio repositorio;
	


	public CotizacionCUseCaseImpl(ICotizacionCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CotizacionC guardar(CotizacionC nuevaCotizacion) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaCotizacion);
	}

	@Override
	public CotizacionC buscarPorId(int idCotizacionC) {
		// TODO Auto-generated method stub
		return repositorio
				.buscarPorId(idCotizacionC)
				.orElseThrow(() -> new RuntimeException("No se encontro los datos"));
	}

	@Override
	public List<CotizacionC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idCotizacionC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idCotizacionC);
	}

}
