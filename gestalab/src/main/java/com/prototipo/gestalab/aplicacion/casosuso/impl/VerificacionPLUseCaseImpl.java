package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IVerificacionPLUseCase;
import com.prototipo.gestalab.dominio.entidades.VerificacionPL;
import com.prototipo.gestalab.dominio.repositorio.IVerificacionPLRepositorio;

public class VerificacionPLUseCaseImpl implements IVerificacionPLUseCase{
	
	private final IVerificacionPLRepositorio repositorio;

	public VerificacionPLUseCaseImpl(IVerificacionPLRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public VerificacionPL guardar(VerificacionPL nuevoVerificacionPL) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevoVerificacionPL);
	}

	@Override
	public VerificacionPL buscarPorId(int idVerificacion) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idVerificacion)
				.orElseThrow(() -> new RuntimeException("Infoemacion no encontrada"));
	}

	@Override
	public List<VerificacionPL> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idVerificacion) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idVerificacion);
	}

}
