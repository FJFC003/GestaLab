package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICargoUseCase;
import com.prototipo.gestalab.dominio.entidades.Cargo;
import com.prototipo.gestalab.dominio.repositorio.ICargoRepositorio;

public class CargoUseCaseImpl implements ICargoUseCase{
	
	private final ICargoRepositorio repositorio;

	public CargoUseCaseImpl(ICargoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Cargo guardar(Cargo nuevoCargo) {
		return repositorio.guardar(nuevoCargo);
	}

	@Override
	public Cargo buscarPorId(int idCargo) {
		return repositorio
				.buscarPorId(idCargo)
				.orElseThrow(() -> new RuntimeException("Informacion no encontrada"));
	}

	@Override
	public List<Cargo> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idCargo) {
		repositorio.buscarPorId(idCargo);
	}

}
