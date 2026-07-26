package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DescripcionServicioC;
import com.prototipo.gestalab.dominio.repositorio.IDescripcionServicioCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DescripcionServicioCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDescripcionServicioCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IDescripcionServicioCJpaRepositorio;

public class DescripcionServicioCRepositorioImpl implements IDescripcionServicioCRepositorio{
	
	private final IDescripcionServicioCJpaRepositorio jpaRepositorio;
	private final IDescripcionServicioCJpaMapper entityMapper;

	public DescripcionServicioCRepositorioImpl(IDescripcionServicioCJpaRepositorio jpaRepositorio, IDescripcionServicioCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DescripcionServicioC guardar(DescripcionServicioC nuevo) {
		// TODO Auto-generated method stub
		DescripcionServicioCEntity entity = entityMapper.toEntity(nuevo);
		return entityMapper.toDomain(jpaRepositorio.save(entity));
	}

	@Override
	public Optional<DescripcionServicioC> buscarPorId(int idDescripcionServicioC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idDescripcionServicioC).map(entityMapper::toDomain);
	}

	@Override
	public List<DescripcionServicioC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDescripcionServicioC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idDescripcionServicioC);
	}

}
