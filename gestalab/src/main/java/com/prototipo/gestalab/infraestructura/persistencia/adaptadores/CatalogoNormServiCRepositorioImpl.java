package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoNormServiC;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoNormServiCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoNormServiCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICatalogoNormServiCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoNormServiCJpaRepositorio;

public class CatalogoNormServiCRepositorioImpl implements ICatalogoNormServiCRepositorio{
	
	private final ICatalogoNormServiCJpaRepositorio jpaRepositorio;
	private final ICatalogoNormServiCJpaMapper entityMapper;
	
	
	public CatalogoNormServiCRepositorioImpl(ICatalogoNormServiCJpaRepositorio jpaRepositorio,
			ICatalogoNormServiCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}
	@Override
	public CatalogoNormServiC guardar(CatalogoNormServiC nuevoCatalogoNorm) {
		CatalogoNormServiCEntity entity = entityMapper.toEntity(nuevoCatalogoNorm);
		CatalogoNormServiCEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}
	@Override
	public Optional<CatalogoNormServiC> buscarPorId(int idCatalogoNormServi) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idCatalogoNormServi).map(entityMapper::toDomain);
	}
	@Override
	public List<CatalogoNormServiC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}
	@Override
	public void eliminar(int idCatalogoNormServi) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idCatalogoNormServi);
	}

	
}