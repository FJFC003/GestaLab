package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.dominio.repositorio.IEquiposUtilizadosIRRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EquiposUtilizadosIREntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEquiposUtilizadosIRJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IEquiposUtilizadosIRJpaRepositorio;

public class EquiposUtilizadosIRRepositorioImpl implements IEquiposUtilizadosIRRepositorio{
	
	private final IEquiposUtilizadosIRJpaRepositorio jpaRepositorio;
	private final IEquiposUtilizadosIRJpaMapper entityMapper;

	public EquiposUtilizadosIRRepositorioImpl(IEquiposUtilizadosIRJpaRepositorio jpaRepositorio,
			IEquiposUtilizadosIRJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public EquiposUtilizadosIR guardar(EquiposUtilizadosIR nuevo) {
		EquiposUtilizadosIREntity entity = entityMapper.toEntity(nuevo);
		EquiposUtilizadosIREntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<EquiposUtilizadosIR> buscarPorId(int idEquipos) {
		return jpaRepositorio.findById(idEquipos).map(entityMapper::toDomain);
	}

	@Override
	public List<EquiposUtilizadosIR> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idEquipos) {
		jpaRepositorio.deleteById(idEquipos);
	}

	@Override
	public List<EquiposUtilizadosIR> listarPorInforme(int idInforme) {
		return jpaRepositorio.findByFkInformeEntity_IdInforme(idInforme)
				.stream().map(entityMapper::toDomain).toList();
	}

}
