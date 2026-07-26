package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.PlazoEntregaC;
import com.prototipo.gestalab.dominio.repositorio.IPlazoEntregaCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlazoEntregaCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IPlazoEntregaCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IPlazoEntregaCJpaRepositorio;

public class PlazoEntregaCRepositorioImpl implements IPlazoEntregaCRepositorio{
	
	private final IPlazoEntregaCJpaRepositorio jpaRepositorio;
	private final IPlazoEntregaCJpaMapper entityMapper;

	public PlazoEntregaCRepositorioImpl(IPlazoEntregaCJpaRepositorio jpaRepositorio, IPlazoEntregaCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public PlazoEntregaC guardar(PlazoEntregaC nuevo) {
		// TODO Auto-generated method stub
		PlazoEntregaCEntity entity = entityMapper.toEntity(nuevo);
		return entityMapper.toDomain(jpaRepositorio.save(entity));
	}

	@Override
	public Optional<PlazoEntregaC> buscarPorId(int idPlazoEntregaC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idPlazoEntregaC).map(entityMapper::toDomain);
	}

	@Override
	public List<PlazoEntregaC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idPlazoEntregaC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idPlazoEntregaC);
	}

}
