package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ITipoTomaFreHoraPLUseCase;
import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;
import com.prototipo.gestalab.dominio.repositorio.ITipoTomaFreHoraPLRepositorio;

public class TipoTomaFreHoraPLUseCaseImpl implements ITipoTomaFreHoraPLUseCase{
	
	private final ITipoTomaFreHoraPLRepositorio repositorio;

	public TipoTomaFreHoraPLUseCaseImpl(ITipoTomaFreHoraPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public TipoTomaFreHoraPL guardar(TipoTomaFreHoraPL nuevoTipoTomaFreHoraPL) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoTipoTomaFreHoraPL);
	}

	@Override
	public TipoTomaFreHoraPL buscarPorId(int idTipoFre) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idTipoFre)
				.orElseThrow(() -> new RuntimeException("Informacio no encontrada"));
	}

	@Override
	public List<TipoTomaFreHoraPL> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idTipoFre) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idTipoFre);
	}

}
