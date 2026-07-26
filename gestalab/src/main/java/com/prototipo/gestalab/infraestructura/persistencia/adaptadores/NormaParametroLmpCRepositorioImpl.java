package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.NormaParametroLmpC;
import com.prototipo.gestalab.dominio.repositorio.INormaParametroLmpCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.NormaParametroLmpCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.INormaParametroLmpCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoNormServiCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoParametroCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ILmpCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.INormaParametroLmpCJpaRepositorio;

public class NormaParametroLmpCRepositorioImpl implements INormaParametroLmpCRepositorio{
	
	private final INormaParametroLmpCJpaRepositorio jpaRepositorio;
	private final INormaParametroLmpCJpaMapper entityMapper;
	private final ICatalogoNormServiCJpaRepositorio normaCJpaRepositorio;
	private final ICatalogoParametroCJpaRepositorio parametroCJpaRepositorio;
	private final ILmpCJpaRepositorio lmpCJpaRepositorio;

	public NormaParametroLmpCRepositorioImpl(INormaParametroLmpCJpaRepositorio jpaRepositorio,
			INormaParametroLmpCJpaMapper entityMapper,
			ICatalogoNormServiCJpaRepositorio normaCJpaRepositorio,
			ICatalogoParametroCJpaRepositorio parametroCJpaRepositorio,
			ILmpCJpaRepositorio lmpCJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.normaCJpaRepositorio = normaCJpaRepositorio;
		this.parametroCJpaRepositorio = parametroCJpaRepositorio;
		this.lmpCJpaRepositorio = lmpCJpaRepositorio;
	}

	@Override
	public NormaParametroLmpC guardar(NormaParametroLmpC nuevo) {
		// TODO Auto-generated method stub
		NormaParametroLmpCEntity entity = entityMapper.toEntity(nuevo);

		if (nuevo.getFkNorma() != null && nuevo.getFkNorma().getIdCatalogoNormServi() > 0) {
			entity.setFkNormaEntity(
					normaCJpaRepositorio.findById(nuevo.getFkNorma().getIdCatalogoNormServi()).orElse(null));
		} else {
			entity.setFkNormaEntity(null);
		}

		if (nuevo.getFkParametro() != null && nuevo.getFkParametro().getIdParametroC() > 0) {
			entity.setFkParametroEntity(
					parametroCJpaRepositorio.findById(nuevo.getFkParametro().getIdParametroC()).orElse(null));
		} else {
			entity.setFkParametroEntity(null);
		}

		if (nuevo.getFkLmp() != null && nuevo.getFkLmp().getIdLmpC() > 0) {
			entity.setFkLmpEntity(
					lmpCJpaRepositorio.findById(nuevo.getFkLmp().getIdLmpC()).orElse(null));
		} else {
			entity.setFkLmpEntity(null);
		}

		NormaParametroLmpCEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<NormaParametroLmpC> buscarPorId(int idNormaParametroLmpC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idNormaParametroLmpC).map(entityMapper::toDomain);
	}

	@Override
	public List<NormaParametroLmpC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<NormaParametroLmpC> buscarPorNorma(int idCatalogoNormServi) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findByFkNormaEntity_IdCatalogoNormServi(idCatalogoNormServi)
				.stream()
				.map(entityMapper::toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idNormaParametroLmpC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idNormaParametroLmpC);
	}

}
