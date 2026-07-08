package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.UsuariohasRolEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IUsuariohasRolJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuariohasRolJpaRepositorio;

public class UsuariohasRolRepositorioImpl implements IUsuariohasRolRepositorio{
	
	private final IUsuariohasRolJpaRepositorio jpaRepositorio;
	private final IUsuariohasRolJpaMapper entityMapper;

	public UsuariohasRolRepositorioImpl(IUsuariohasRolJpaRepositorio jpaRepositorio,
			IUsuariohasRolJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public UsuariohasRol guardar(UsuariohasRol nuevoUsuariohasRol) {
		UsuariohasRolEntity entity = entityMapper.toEntity(nuevoUsuariohasRol);
		UsuariohasRolEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<UsuariohasRol> buscarPorId(int idUsuarioRol) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idUsuarioRol).map(entityMapper::toDomain);
	}

	@Override
	public List<UsuariohasRol> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idUsuarioRol) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idUsuarioRol);
	}

}
