package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.TipoTomaMuestraC;
import com.prototipo.gestalab.dominio.repositorio.ITipoTomaMuestraCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.TipoTomaMuestraCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ITipoTomaMuestraCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ITipoTomaMuestraCJpaRepositorio;

public class TipoTomaMuestraCRepositorioImpl implements ITipoTomaMuestraCRepositorio {

	private final ITipoTomaMuestraCJpaRepositorio jpaRepositorio;
	private final ITipoTomaMuestraCJpaMapper entityMapper;

	public TipoTomaMuestraCRepositorioImpl(ITipoTomaMuestraCJpaRepositorio jpaRepositorio,
			ITipoTomaMuestraCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public TipoTomaMuestraC guardar(TipoTomaMuestraC nuevo) {
		TipoTomaMuestraCEntity entity = entityMapper.toEntity(nuevo);
		return entityMapper.toDomain(jpaRepositorio.save(entity));
	}

	@Override
	public Optional<TipoTomaMuestraC> buscarPorId(int idTipoTomaMuestraC) {
		return jpaRepositorio.findById(idTipoTomaMuestraC).map(entityMapper::toDomain);
	}

	@Override
	public List<TipoTomaMuestraC> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idTipoTomaMuestraC) {
		jpaRepositorio.deleteById(idTipoTomaMuestraC);
	}

}
