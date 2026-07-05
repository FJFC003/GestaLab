package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;
import com.prototipo.gestalab.dominio.repositorio.IPlanMuestreoPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlanMuestreoPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IPlanMuestreoPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IPlanMuestreoPLJpaRepositorio;

public class PlanMuestreoPLRepositorioImpl implements IPlanMuestreoPLRepositorio{
	
	private final IPlanMuestreoPLJpaRepositorio jpaRepositorio;
	private final IPlanMuestreoPLJpaMapper entityMapper;
	
	

	public PlanMuestreoPLRepositorioImpl(IPlanMuestreoPLJpaRepositorio jpaRepositorio,
			IPlanMuestreoPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public PlanMuestreoPL guardar(PlanMuestreoPL nuevoPlan) {
		PlanMuestreoPLEntity entity = entityMapper.toEntity(nuevoPlan);
		PlanMuestreoPLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<PlanMuestreoPL> buscarPorId(int idPlan) {
		return jpaRepositorio.findById(idPlan).map(entityMapper::toDomain);
	}

	@Override
	public List<PlanMuestreoPL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idPlan) {
		jpaRepositorio.deleteById(idPlan);
		
	}

}
