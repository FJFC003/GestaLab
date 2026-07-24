package com.prototipo.gestalab.aplicacion.casosuso.impl;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ILoginUseCase;
import com.prototipo.gestalab.dominio.entidades.Login;
import com.prototipo.gestalab.dominio.repositorio.ILoginRepositorio;

public class LoginUseCaseImpl implements ILoginUseCase{
	
	private final ILoginRepositorio repositorio;

	public LoginUseCaseImpl(ILoginRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Login guardar(Login nuevologin) {
		// TODO Auto-generated method stub
		return repositorio.guardar(nuevologin);
	}

}
