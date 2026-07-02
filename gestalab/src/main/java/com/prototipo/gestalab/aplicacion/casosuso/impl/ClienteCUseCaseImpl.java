package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IClienteCUseCase;
import com.prototipo.gestalab.dominio.entidades.ClienteC;
import com.prototipo.gestalab.dominio.repositorio.IClienteCRepositorio;

public class ClienteCUseCaseImpl implements IClienteCUseCase{
	
	private final IClienteCRepositorio repositorio;
	

	public ClienteCUseCaseImpl(IClienteCRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public ClienteC guardar(ClienteC nuevaCliente) {
		return repositorio.guardar(nuevaCliente);
	}

	@Override
	public ClienteC buscarPorId(int idClienteC) {
		return repositorio.buscarPorId(idClienteC).orElseThrow(() -> new RuntimeException("Informacion no enconrada"));
	}

	@Override
	public List<ClienteC> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idClienteC) {
		repositorio.eliminar(idClienteC);
		
	}

}
