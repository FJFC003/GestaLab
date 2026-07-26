package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDescripcionServicioCUseCase;
import com.prototipo.gestalab.dominio.entidades.DescripcionServicioC;
import com.prototipo.gestalab.dominio.repositorio.IDescripcionServicioCRepositorio;

public class DescripcionServicioCUseCaseImpl implements IDescripcionServicioCUseCase{
	
	private final IDescripcionServicioCRepositorio repositorio;

	public DescripcionServicioCUseCaseImpl(IDescripcionServicioCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public DescripcionServicioC guardar(DescripcionServicioC nuevo) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevo);
	}

	@Override
	public DescripcionServicioC buscarPorId(int idDescripcionServicioC) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idDescripcionServicioC)
				.orElseThrow(() -> new RuntimeException("No se encontró: Descripción de Servicio"));
	}

	@Override
	public List<DescripcionServicioC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idDescripcionServicioC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idDescripcionServicioC);
	}

	

	

}
