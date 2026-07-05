package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;
import com.prototipo.gestalab.dominio.repositorio.ITipoTomaFreHoraPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.TipoTomaFreHoraPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ITipoTomaFreHoraPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ITipoTomaFreHoraPLJpaRepositorio;

public class TipoTomaFreHoraPLRepositorioImpl implements ITipoTomaFreHoraPLRepositorio{
	
	private final ITipoTomaFreHoraPLJpaRepositorio jpaRepositorio;
	private final ITipoTomaFreHoraPLJpaMapper entityMapper;

	public TipoTomaFreHoraPLRepositorioImpl(ITipoTomaFreHoraPLJpaRepositorio jpaRepositorio,
			ITipoTomaFreHoraPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public TipoTomaFreHoraPL guardar(TipoTomaFreHoraPL nuevoTipoTomaFreHoraPL) {
		TipoTomaFreHoraPLEntity entity = entityMapper.toEntity(nuevoTipoTomaFreHoraPL);
		TipoTomaFreHoraPLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<TipoTomaFreHoraPL> buscarPorId(int idTipoFre) {
		return jpaRepositorio.findById(idTipoFre).map(entityMapper::toDomain);
	}

	@Override
	public List<TipoTomaFreHoraPL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idTipoFre) {
		jpaRepositorio.deleteById(idTipoFre);
		
	}

}
