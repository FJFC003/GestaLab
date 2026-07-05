package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;
import com.prototipo.gestalab.dominio.repositorio.IParametroAnalizarPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ParametroAnalizarPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IParametroAnalizarPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IParametroAnalizarPLJpaRepositorio;

public class ParametroAnalizarPLRepositorioImpl implements IParametroAnalizarPLRepositorio{
	
	private final IParametroAnalizarPLJpaRepositorio jpaRepositorio;
	private final IParametroAnalizarPLJpaMapper entityMapper;
	
	

	public ParametroAnalizarPLRepositorioImpl(IParametroAnalizarPLJpaRepositorio jpaRepositorio,
			IParametroAnalizarPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ParametroAnalizarPL guardar(ParametroAnalizarPL nuevoParameAnali) {
		ParametroAnalizarPLEntity entity = entityMapper.toEntity(nuevoParameAnali);
		ParametroAnalizarPLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<ParametroAnalizarPL> buscarPorId(int idParametroPL) {
		return jpaRepositorio.findById(idParametroPL).map(entityMapper::toDomain);
	}

	@Override
	public List<ParametroAnalizarPL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idParametroPL) {
		jpaRepositorio.deleteById(idParametroPL);
		
	}

}
