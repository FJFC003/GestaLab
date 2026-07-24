package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import com.prototipo.gestalab.dominio.entidades.Login;
import com.prototipo.gestalab.dominio.repositorio.ILoginRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.LoginEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ILoginJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ILoginJpaRepositorio;

public class LoginRepositorioImpl implements ILoginRepositorio{
	
	private final ILoginJpaRepositorio jpaRepositorio;
	private final ILoginJpaMapper entityMapper;

	public LoginRepositorioImpl(ILoginJpaRepositorio jpaRepositorio, ILoginJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Login guardar(Login nuevologin) {
		// TODO Auto-generated method stub
		LoginEntity entity = entityMapper.toEntity(nuevologin);
		LoginEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
		
		
	}

}
