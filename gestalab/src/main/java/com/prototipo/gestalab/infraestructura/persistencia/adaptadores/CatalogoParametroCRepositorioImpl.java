package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoParametroCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoParametrosCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICatalogoParametrosCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoParametroCJpaRepositorio;

public class CatalogoParametroCRepositorioImpl implements ICatalogoParametroCRepositorio{
	
	private final ICatalogoParametroCJpaRepositorio jpaRepositorio;
	private final ICatalogoParametrosCJpaMapper entityMapper;

	public CatalogoParametroCRepositorioImpl(ICatalogoParametroCJpaRepositorio jpaRepositorio,
			ICatalogoParametrosCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public CatalogoParametroC guardar(CatalogoParametroC nuevaCataPara) {
		CatalogoParametrosCEntity entity = entityMapper.toEntity(nuevaCataPara);
		CatalogoParametrosCEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<CatalogoParametroC> buscarPorId(int idParametroC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idParametroC).map(entityMapper::toDomain);
	}

	@Override
	public List<CatalogoParametroC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idParametroC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idParametroC);
	}

}
