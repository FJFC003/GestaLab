package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Rol;
import com.prototipo.gestalab.dominio.repositorio.IRolRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RolEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IRolJpaRepositorio;

public class RolRepositorioImpl implements IRolRepositorio{
	
	private final IRolJpaRepositorio jpaRepositorio;
	private final IRolJpaMapper entityMapper;

	public RolRepositorioImpl(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Rol guardar(Rol nuevoRol) {
		RolEntity entity = entityMapper.toEntity(nuevoRol);
		RolEntity guargar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guargar);
	}

	@Override
	public Optional<Rol> buscarPorId(int idRol) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idRol).map(entityMapper::toDomain);
	}

	@Override
	public List<Rol> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idRol) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idRol);
	}

}
