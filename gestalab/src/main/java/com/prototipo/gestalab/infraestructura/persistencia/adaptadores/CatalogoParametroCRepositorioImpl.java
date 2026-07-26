package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoParametroCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoParametrosCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CondicionParametroCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICatalogoParametrosCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoParametroCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICondicionParametroCJpaRepositorio;

public class CatalogoParametroCRepositorioImpl implements ICatalogoParametroCRepositorio{
	
	private final ICatalogoParametroCJpaRepositorio jpaRepositorio;
	private final ICatalogoParametrosCJpaMapper entityMapper;
	private final ICondicionParametroCJpaRepositorio condicionJpaRepositorio;

	public CatalogoParametroCRepositorioImpl(ICatalogoParametroCJpaRepositorio jpaRepositorio,
			ICatalogoParametrosCJpaMapper entityMapper, ICondicionParametroCJpaRepositorio condicionJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.condicionJpaRepositorio = condicionJpaRepositorio;
	}

	@Override
	public CatalogoParametroC guardar(CatalogoParametroC nuevaCataPara) {
		int idCondicion = nuevaCataPara.getFkCondicionParametro() != null
				? nuevaCataPara.getFkCondicionParametro().getIdCondicionParametroC()
				: 0;

		if (idCondicion <= 0) {
			throw new IllegalArgumentException("Debe seleccionar una condición del parámetro válida");
		}

		CatalogoParametrosCEntity entity = entityMapper.toEntity(nuevaCataPara);

		
		CondicionParametroCEntity condicionRef = condicionJpaRepositorio.getReferenceById(idCondicion);
		entity.setFkCondicionParametroEntity(condicionRef);

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
