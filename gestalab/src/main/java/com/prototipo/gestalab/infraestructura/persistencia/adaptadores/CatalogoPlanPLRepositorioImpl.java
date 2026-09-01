package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoPlanPL;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoPlanPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoPlanPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICatalogoPlanPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoPlanPLJpaRepositorio;

public class CatalogoPlanPLRepositorioImpl implements ICatalogoPlanPLRepositorio {

	private final ICatalogoPlanPLJpaRepositorio jpaRepositorio;
	private final ICatalogoPlanPLJpaMapper entityMapper;

	public CatalogoPlanPLRepositorioImpl(ICatalogoPlanPLJpaRepositorio jpaRepositorio,
			ICatalogoPlanPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public CatalogoPlanPL guardar(CatalogoPlanPL nuevo) {
		CatalogoPlanPLEntity entity = entityMapper.toEntity(nuevo);
		return entityMapper.toDomain(jpaRepositorio.save(entity));
	}

	@Override
	public Optional<CatalogoPlanPL> buscarPorId(int idCatalogoPlanPL) {
		return jpaRepositorio.findById(idCatalogoPlanPL).map(entityMapper::toDomain);
	}

	@Override
	public List<CatalogoPlanPL> ListarTodos() {
		return jpaRepositorio.findAllByOrderByTipoListaAscOrdenCatalogoPlanPLAscIdCatalogoPlanPLAsc()
				.stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<CatalogoPlanPL> ListarPorTipo(String tipoLista) {
		return jpaRepositorio.findByTipoListaOrderByOrdenCatalogoPlanPLAscIdCatalogoPlanPLAsc(tipoLista)
				.stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCatalogoPlanPL) {
		jpaRepositorio.deleteById(idCatalogoPlanPL);
	}

}
