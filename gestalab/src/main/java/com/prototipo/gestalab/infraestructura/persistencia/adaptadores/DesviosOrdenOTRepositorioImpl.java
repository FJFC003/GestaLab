package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DesviosOrdenOT;
import com.prototipo.gestalab.dominio.repositorio.IDesviosOrdenOTRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DesviosOrdenOTEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDesviosOrdenOTJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IDesviosOrdenOTJpaRepositorio;

public class DesviosOrdenOTRepositorioImpl implements IDesviosOrdenOTRepositorio{
	
	private final IDesviosOrdenOTJpaRepositorio jpaRepositorio;
	private final IDesviosOrdenOTJpaMapper entityMapper;
	
	

	public DesviosOrdenOTRepositorioImpl(IDesviosOrdenOTJpaRepositorio jpaRepositorio,
			IDesviosOrdenOTJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DesviosOrdenOT guardar(DesviosOrdenOT nuevoDesviosOrdenOT) {
		DesviosOrdenOTEntity entity = entityMapper.toEntity(nuevoDesviosOrdenOT);
		DesviosOrdenOTEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<DesviosOrdenOT> buscarPorId(int idDesviosOrdenOT) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idDesviosOrdenOT).map(entityMapper::toDomain);
	}

	@Override
	public List<DesviosOrdenOT> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDesviosOrdenOT) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idDesviosOrdenOT);
	}

}
