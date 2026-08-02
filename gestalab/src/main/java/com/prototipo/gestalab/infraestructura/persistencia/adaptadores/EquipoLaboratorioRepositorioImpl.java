package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.EquipoLaboratorio;
import com.prototipo.gestalab.dominio.repositorio.IEquipoLaboratorioRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EquipoLaboratorioEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEquipoLaboratorioJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IEquipoLaboratorioJpaRepositorio;

public class EquipoLaboratorioRepositorioImpl implements IEquipoLaboratorioRepositorio{

	private final IEquipoLaboratorioJpaRepositorio jpaRepositorio;
	private final IEquipoLaboratorioJpaMapper entityMapper;

	public EquipoLaboratorioRepositorioImpl(IEquipoLaboratorioJpaRepositorio jpaRepositorio,
			IEquipoLaboratorioJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public EquipoLaboratorio guardar(EquipoLaboratorio nuevoEquipoLaboratorio) {
		EquipoLaboratorioEntity entity = entityMapper.toEntity(nuevoEquipoLaboratorio);
		EquipoLaboratorioEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<EquipoLaboratorio> buscarPorId(int idEquipoLab) {
		return jpaRepositorio.findById(idEquipoLab).map(entityMapper::toDomain);
	}

	@Override
	public List<EquipoLaboratorio> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idEquipoLab) {
		jpaRepositorio.deleteById(idEquipoLab);
	}

}