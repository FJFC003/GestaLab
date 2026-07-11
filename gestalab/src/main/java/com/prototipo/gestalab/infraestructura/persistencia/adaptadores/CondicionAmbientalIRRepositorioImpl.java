package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.dominio.repositorio.ICondicionAmbientalIRRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CondicionAmbientalIREntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICondicionAmbientalIRJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICondicionAmbientalIRJpaRepositorio;

public class CondicionAmbientalIRRepositorioImpl implements ICondicionAmbientalIRRepositorio{
	
	private final ICondicionAmbientalIRJpaRepositorio jpaRepositorio;
	private final ICondicionAmbientalIRJpaMapper entityMapper;
	
	

	public CondicionAmbientalIRRepositorioImpl(ICondicionAmbientalIRJpaRepositorio jpaRepositorio,
			ICondicionAmbientalIRJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public CondicionAmbientalIR guardar(CondicionAmbientalIR nuevoCondicionAmbientalIR) {
		CondicionAmbientalIREntity entity = entityMapper.toEntity(nuevoCondicionAmbientalIR);
		CondicionAmbientalIREntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<CondicionAmbientalIR> buscarPorId(int idCondi) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idCondi).map(entityMapper::toDomain);
	}

	@Override
	public List<CondicionAmbientalIR> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCondi) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idCondi);
	}

}
