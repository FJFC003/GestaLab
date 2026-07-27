package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;
import com.prototipo.gestalab.dominio.repositorio.IOrdenTrabajoOTRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.OrdenTrabajoOTEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IOrdenTrabajoOTJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IOrdenTrabajoOTJpaRepositorio;

public class OrdenTrabajoOTRepositorioImpl implements IOrdenTrabajoOTRepositorio{

	private final IOrdenTrabajoOTJpaRepositorio jpaRepositorio;
	private final IOrdenTrabajoOTJpaMapper entityMapper;

	public OrdenTrabajoOTRepositorioImpl(IOrdenTrabajoOTJpaRepositorio jpaRepositorio,
			IOrdenTrabajoOTJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public OrdenTrabajoOT guardar(OrdenTrabajoOT nuevaOrdenTrabajoOT) {
		OrdenTrabajoOTEntity entity = entityMapper.toEntity(nuevaOrdenTrabajoOT);
		OrdenTrabajoOTEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<OrdenTrabajoOT> buscarPorId(int idOT) {
		return jpaRepositorio.findById(idOT).map(entityMapper::toDomain);
	}

	@Override
	public List<OrdenTrabajoOT> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idOt) {
		jpaRepositorio.deleteById(idOt);
	}

	@Override
	public List<OrdenTrabajoOT> listarPorTecnico(int idEmpleado) {
		return jpaRepositorio.findByFkTecnicoAsignadoEntity_IdEmpleado(idEmpleado)
				.stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<OrdenTrabajoOT> listarPorPlan(int idPlan) {
		return jpaRepositorio.findByFkPlanMuestreoEntity_IdPlan(idPlan)
				.stream().map(entityMapper::toDomain).toList();
	}

}
