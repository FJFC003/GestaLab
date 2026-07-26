package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IPlazoEntregaCUseCase;
import com.prototipo.gestalab.dominio.entidades.PlazoEntregaC;
import com.prototipo.gestalab.dominio.repositorio.IPlazoEntregaCRepositorio;

public class PlazoEntregaCUseCaseImpl implements IPlazoEntregaCUseCase{
	
	private final IPlazoEntregaCRepositorio repositorio;

	public PlazoEntregaCUseCaseImpl(IPlazoEntregaCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public PlazoEntregaC guardar(PlazoEntregaC nuevo) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevo);
	}

	@Override
	public PlazoEntregaC buscarPorId(int idPlazoEntregaC) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idPlazoEntregaC)
				.orElseThrow(() -> new RuntimeException("No se encontró: Plazo de Entrega"));
	}

	@Override
	public List<PlazoEntregaC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idPlazoEntregaC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idPlazoEntregaC);
	}

}
