package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ILmpCUseCase;
import com.prototipo.gestalab.dominio.entidades.LmpC;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.ILmpCRepositorio;

public class LmpCUseCaseImpl implements ILmpCUseCase{
	
	private final ILmpCRepositorio repositorio;

	public LmpCUseCaseImpl(ILmpCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public LmpC guardar(LmpC nuevo) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevo);
	}

	@Override
	public LmpC buscarPorId(int idLmpC) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idLmpC)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<LmpC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idLmpC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idLmpC);
	}

	

	

}
