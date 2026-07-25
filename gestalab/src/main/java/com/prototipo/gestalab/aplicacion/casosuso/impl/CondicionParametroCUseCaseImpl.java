package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICondicionParametroCUseCase;
import com.prototipo.gestalab.dominio.entidades.CondicionParametroC;
import com.prototipo.gestalab.dominio.repositorio.ICondicionParametroCRepositorio;

public class CondicionParametroCUseCaseImpl implements ICondicionParametroCUseCase{
	
	private final ICondicionParametroCRepositorio repositorio;

	public CondicionParametroCUseCaseImpl(ICondicionParametroCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public CondicionParametroC guardar(CondicionParametroC nuevo) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevo);
	}

	@Override
	public CondicionParametroC buscarPorId(int idCondicionParametroC) {
		return repositorio.buscarPorId(idCondicionParametroC)
				.orElseThrow(() -> new RuntimeException("No se encontró la condición"));
	}

	@Override
	public List<CondicionParametroC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idCondicionParametroC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idCondicionParametroC);
	}

}
