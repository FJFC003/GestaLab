package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoPlanPLUseCase;
import com.prototipo.gestalab.dominio.entidades.CatalogoPlanPL;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoPlanPLRepositorio;

public class CatalogoPlanPLUseCaseImpl implements ICatalogoPlanPLUseCase {

	private final ICatalogoPlanPLRepositorio repositorio;

	public CatalogoPlanPLUseCaseImpl(ICatalogoPlanPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CatalogoPlanPL guardar(CatalogoPlanPL nuevo) {
		return repositorio.guardar(nuevo);
	}

	@Override
	public CatalogoPlanPL buscarPorId(int idCatalogoPlanPL) {
		return repositorio.buscarPorId(idCatalogoPlanPL)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<CatalogoPlanPL> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public List<CatalogoPlanPL> ListarPorTipo(String tipoLista) {
		return repositorio.ListarPorTipo(tipoLista);
	}

	@Override
	public void eliminar(int idCatalogoPlanPL) {
		repositorio.eliminar(idCatalogoPlanPL);
	}

}
