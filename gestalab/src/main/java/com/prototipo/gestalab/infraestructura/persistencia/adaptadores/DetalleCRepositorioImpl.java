package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.dominio.repositorio.IDetalleCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDetalleCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IDetalleCJpaRepositorio;

public class DetalleCRepositorioImpl implements IDetalleCRepositorio{
	
	private final IDetalleCJpaRepositorio jpaRepositorio;
	private final IDetalleCJpaMapper entityMapper;
	

	public DetalleCRepositorioImpl(IDetalleCJpaRepositorio jpaRepositorio, IDetalleCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DetalleC guardar(DetalleC nuevoDetalleC) {
		DetalleCEntity entity = entityMapper.toEntity(nuevoDetalleC);
		DetalleCEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<DetalleC> buscarPorId(int idDetalleC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idDetalleC).map(entityMapper :: toDomain);
	}

	@Override
	public List<DetalleC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDetalleC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idDetalleC);
	}

}
