package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CondicionParametroC;
import com.prototipo.gestalab.dominio.repositorio.ICondicionParametroCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CondicionParametroCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICondicionParametroCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICondicionParametroCJpaRepositorio;

public class CondicionParametroCRepositorioImpl implements ICondicionParametroCRepositorio{
	
	private final ICondicionParametroCJpaRepositorio jpaRepositorio;
	private final ICondicionParametroCJpaMapper entityMapper;


	public CondicionParametroCRepositorioImpl(ICondicionParametroCJpaRepositorio jpaRepositorio,
			ICondicionParametroCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public CondicionParametroC guardar(CondicionParametroC nuevo) {
		CondicionParametroCEntity entity = entityMapper.toEntity(nuevo);
		return entityMapper.toDomain(jpaRepositorio.save(entity));
	}

	@Override
	public Optional<CondicionParametroC> buscarPorId(int idCondicionParametroC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idCondicionParametroC).map(entityMapper::toDomain);
	}

	@Override
	public List<CondicionParametroC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCondicionParametroC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idCondicionParametroC);
	}

}
