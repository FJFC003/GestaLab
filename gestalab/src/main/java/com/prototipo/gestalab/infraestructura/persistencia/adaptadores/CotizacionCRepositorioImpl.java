package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.dominio.repositorio.ICotizacionCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CotizacionCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICotizacionCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICotizacionCJpaRepositorio;

public class CotizacionCRepositorioImpl implements ICotizacionCRepositorio{
	
	private final ICotizacionCJpaRepositorio jpaRepositorio;
	private final ICotizacionCJpaMapper entityMapper;
	
	

	public CotizacionCRepositorioImpl(ICotizacionCJpaRepositorio jpaRepositorio, ICotizacionCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public CotizacionC guardar(CotizacionC nuevoCotizacionC) {
		CotizacionCEntity entity = entityMapper.toEntity(nuevoCotizacionC);
		CotizacionCEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<CotizacionC> buscarPorId(int idCotizacionC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idCotizacionC).map(entityMapper :: toDomain);
	}

	@Override
	public List<CotizacionC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCotizacionC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idCotizacionC);
	}

}
