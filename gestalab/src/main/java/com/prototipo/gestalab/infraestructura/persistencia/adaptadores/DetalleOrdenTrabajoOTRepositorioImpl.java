package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DetalleOrdenTrabajoOT;
import com.prototipo.gestalab.dominio.repositorio.IDetalleOrdenTrabajoOTRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleOrdenTrabajoOTEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDetalleOrdenTrabajoOTJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IDetalleOrdenTrabajoOTJpaRepositorio;

public class DetalleOrdenTrabajoOTRepositorioImpl implements IDetalleOrdenTrabajoOTRepositorio{
	
	private final IDetalleOrdenTrabajoOTJpaRepositorio jpaRepositorio;
	private final IDetalleOrdenTrabajoOTJpaMapper entityMapper;
	
	

	public DetalleOrdenTrabajoOTRepositorioImpl(IDetalleOrdenTrabajoOTJpaRepositorio jpaRepositorio,
			IDetalleOrdenTrabajoOTJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DetalleOrdenTrabajoOT guardar(DetalleOrdenTrabajoOT nuevoDetalleOrdenTrabajo) {
		DetalleOrdenTrabajoOTEntity entity = entityMapper.toEntity(nuevoDetalleOrdenTrabajo);
		DetalleOrdenTrabajoOTEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<DetalleOrdenTrabajoOT> buscarPorId(int idDetalleOrdenOT) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idDetalleOrdenOT)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<DetalleOrdenTrabajoOT> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll()
				.stream().map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idDetalleOrdenOT) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idDetalleOrdenOT);
	}

}
