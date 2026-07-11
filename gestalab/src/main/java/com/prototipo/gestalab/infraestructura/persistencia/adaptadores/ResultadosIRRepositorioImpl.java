package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.ResultadosIR;
import com.prototipo.gestalab.dominio.repositorio.IResultadosIRRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ResultadosIREntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IResultadosIRJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IResultadosIRJpaRepositorio;

public class ResultadosIRRepositorioImpl implements IResultadosIRRepositorio{
	
	private final IResultadosIRJpaRepositorio jpaRepositorio;
	private final IResultadosIRJpaMapper entityMapper;

	public ResultadosIRRepositorioImpl(IResultadosIRJpaRepositorio jpaRepositorio,
			IResultadosIRJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ResultadosIR guardar(ResultadosIR nuevoResultadosIR) {
		ResultadosIREntity entity = entityMapper.toEntity(nuevoResultadosIR);
		ResultadosIREntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<ResultadosIR> buscarPorId(int idResultados) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idResultados).map(entityMapper::toDomain);
	}

	@Override
	public List<ResultadosIR> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idResultados) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idResultados);
	}

}
