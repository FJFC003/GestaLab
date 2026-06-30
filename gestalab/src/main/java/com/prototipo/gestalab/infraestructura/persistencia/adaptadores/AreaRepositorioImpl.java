package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Area;
import com.prototipo.gestalab.dominio.repositorio.IAreaRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.AreaEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IAreaJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IAreaJpaRepositorio;

public class AreaRepositorioImpl implements IAreaRepositorio{
	
	private final IAreaJpaRepositorio jpaRepositorio;
	private final IAreaJpaMapper entityMapper;
	
	

	public AreaRepositorioImpl(IAreaJpaRepositorio jpaRepositorio, IAreaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Area guardar(Area nuevaArea) {
		AreaEntity entity = entityMapper.toEntity(nuevaArea);
		AreaEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Area> buscarPorId(int idArea) {
		return jpaRepositorio.findById(idArea)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<Area> ListarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idArea) {
		jpaRepositorio.deleteById(idArea);
	}

}
