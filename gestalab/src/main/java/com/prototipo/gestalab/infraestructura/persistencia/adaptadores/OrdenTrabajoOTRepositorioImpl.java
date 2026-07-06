package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;
import com.prototipo.gestalab.dominio.repositorio.IOrdenTrabajoOTRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.OrdenTrabajoOTEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IOrdenTrabajoOTJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IOrdenTrabajoJpaRespositorio;

public class OrdenTrabajoOTRepositorioImpl implements IOrdenTrabajoOTRepositorio{
	
	private final IOrdenTrabajoJpaRespositorio jpaRespositorio;
	private final IOrdenTrabajoOTJpaMapper entityMapper;

	public OrdenTrabajoOTRepositorioImpl(IOrdenTrabajoJpaRespositorio jpaRespositorio,
			IOrdenTrabajoOTJpaMapper entityMapper) {
		super();
		this.jpaRespositorio = jpaRespositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public OrdenTrabajoOT guardar(OrdenTrabajoOT nuevaOrdenTrabajoOT) {
		OrdenTrabajoOTEntity entity = entityMapper.toEntity(nuevaOrdenTrabajoOT);
		OrdenTrabajoOTEntity guardar = jpaRespositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<OrdenTrabajoOT> buscarPorId(int idOT) {
		// TODO Auto-generated method stub
		return jpaRespositorio.findById(idOT).map(entityMapper::toDomain);
	}

	@Override
	public List<OrdenTrabajoOT> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRespositorio.findAll().stream().map(entityMapper:: toDomain).toList();
	}

	@Override
	public void eliminar(int idOt) {
		// TODO Auto-generated method stub
		jpaRespositorio.deleteById(idOt);
	}
	

}
