package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDetalleCUseCase;
import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.dominio.repositorio.IDetalleCRepositorio;

public class DetalleCUseCaseImpl implements IDetalleCUseCase{
	
	private final IDetalleCRepositorio repositorio;


	public DetalleCUseCaseImpl(IDetalleCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public DetalleC guardar(DetalleC nuevaDetalle) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevaDetalle);
	}

	@Override
	public DetalleC buscarPorId(int idDetalleC) {
		// TODO Auto-generated method stub
		return repositorio
				.buscarPorId(idDetalleC)
				.orElseThrow(() -> new RuntimeException("No se encontro los datos"));
	}

	@Override
	public List<DetalleC> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idDetalleC) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idDetalleC);
	}

}
