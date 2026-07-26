package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.LmpC;
import com.prototipo.gestalab.dominio.repositorio.ILmpCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.LmpCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ILmpCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ILmpCJpaRepositorio;

public class LmpCRepositorioImpl implements ILmpCRepositorio{
	
	private final ILmpCJpaRepositorio jpaRepositorio;
	private final ILmpCJpaMapper entityMapper;

	public LmpCRepositorioImpl(ILmpCJpaRepositorio jpaRepositorio, ILmpCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public LmpC guardar(LmpC nuevo) {
		// TODO Auto-generated method stub
		LmpCEntity entity = entityMapper.toEntity(nuevo);
		return entityMapper.toDomain(jpaRepositorio.save(entity));
	}

	@Override
	public Optional<LmpC> buscarPorId(int idLmpC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idLmpC).map(entityMapper::toDomain);
	}

	@Override
	public List<LmpC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idLmpC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idLmpC);
	}

}
