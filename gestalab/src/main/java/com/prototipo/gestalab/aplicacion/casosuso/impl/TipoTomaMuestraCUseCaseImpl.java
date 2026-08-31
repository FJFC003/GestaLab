package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ITipoTomaMuestraCUseCase;
import com.prototipo.gestalab.dominio.entidades.TipoTomaMuestraC;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.ITipoTomaMuestraCRepositorio;

public class TipoTomaMuestraCUseCaseImpl implements ITipoTomaMuestraCUseCase {

	private final ITipoTomaMuestraCRepositorio repositorio;

	public TipoTomaMuestraCUseCaseImpl(ITipoTomaMuestraCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public TipoTomaMuestraC guardar(TipoTomaMuestraC nuevo) {
		return repositorio.guardar(nuevo);
	}

	@Override
	public TipoTomaMuestraC buscarPorId(int idTipoTomaMuestraC) {
		return repositorio.buscarPorId(idTipoTomaMuestraC)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<TipoTomaMuestraC> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idTipoTomaMuestraC) {
		repositorio.eliminar(idTipoTomaMuestraC);
	}

}
