package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoTerminoCondiC;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoTerminoCondiCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoTerminosCondiCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICatalogoTerminosCondiCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoTerminoCondiCJpaRepositorio;

public class CatalogoTerminoCondiCRepositorioImpl implements ICatalogoTerminoCondiCRepositorio{
	
	private final ICatalogoTerminoCondiCJpaRepositorio jpaRepositorio;
	private final ICatalogoTerminosCondiCJpaMapper entityMapper;

	public CatalogoTerminoCondiCRepositorioImpl(ICatalogoTerminoCondiCJpaRepositorio jpaRepositorio,
			ICatalogoTerminosCondiCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public CatalogoTerminoCondiC guardar(CatalogoTerminoCondiC nuevaTerminoCondi) {
		CatalogoTerminosCondiCEntity entity = entityMapper.toEntity(nuevaTerminoCondi);
		CatalogoTerminosCondiCEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<CatalogoTerminoCondiC> buscarPorId(int idTerminoC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idTerminoC).map(entityMapper::toDomain);
	}

	@Override
	public List<CatalogoTerminoCondiC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idTerminoC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idTerminoC);
	}

}
