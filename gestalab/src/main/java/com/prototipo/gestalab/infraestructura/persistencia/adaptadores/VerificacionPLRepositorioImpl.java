package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.VerificacionPL;
import com.prototipo.gestalab.dominio.repositorio.IVerificacionPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.VerificacionPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IVerificacionPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IVerificacionPLJpaRepositorio;

public class VerificacionPLRepositorioImpl implements IVerificacionPLRepositorio{
	
	private final IVerificacionPLJpaRepositorio jpaRepositorio;
	private final IVerificacionPLJpaMapper entityMapper;
	
	

	public VerificacionPLRepositorioImpl(IVerificacionPLJpaRepositorio jpaRepositorio,
			IVerificacionPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public VerificacionPL guardar(VerificacionPL nuevoVerificacionPL) {
		VerificacionPLEntity entity = entityMapper.toEntity(nuevoVerificacionPL);
		VerificacionPLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<VerificacionPL> buscarPorId(int idVerificacion) {
		return jpaRepositorio.findById(idVerificacion).map(entityMapper::toDomain);
	}

	@Override
	public List<VerificacionPL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idVerificacion) {
		jpaRepositorio.deleteById(idVerificacion);
		
	}

}
