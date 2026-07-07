package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RolEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IRolJpaRepositorio;

public class UsuariohasRolRepositorioImpl implements IUsuariohasRolRepositorio{
	
	private final IRolJpaRepositorio jpaRepositorio;
	private final IRolJpaMapper entityMapper;

	public UsuariohasRolRepositorioImpl(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public UsuariohasRol guardar(UsuariohasRol nuevoUsuariohasRol) {
		RolEntity entity = entityMapper
		return null;
	}

	@Override
	public Optional<UsuariohasRol> buscarPorId(int idUsuarioRol) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<UsuariohasRol> ListarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idUsuarioRol) {
		// TODO Auto-generated method stub
		
	}

}
