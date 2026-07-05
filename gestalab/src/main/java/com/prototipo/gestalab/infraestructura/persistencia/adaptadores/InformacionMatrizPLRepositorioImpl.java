package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;
import com.prototipo.gestalab.dominio.repositorio.IInformacionMatrizPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionMatrizPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IInformacionMatrizPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IInformacionMatrizPLJpaRepositorio;

public class InformacionMatrizPLRepositorioImpl implements IInformacionMatrizPLRepositorio{
	
	private final IInformacionMatrizPLJpaRepositorio jpaRepositorio ;
	private final IInformacionMatrizPLJpaMapper entityMapper;
	
	

	public InformacionMatrizPLRepositorioImpl(IInformacionMatrizPLJpaRepositorio jpaRepositorio,
			IInformacionMatrizPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public InformacionMatrizPL guardar(InformacionMatrizPL nuevoInfoMatriz) {
		InformacionMatrizPLEntity entity = entityMapper.toEntity(nuevoInfoMatriz);
		InformacionMatrizPLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<InformacionMatrizPL> buscarPorId(int idInfoMatriz) {
		return jpaRepositorio.findById(idInfoMatriz).map(entityMapper:: toDomain);
	}

	@Override
	public List<InformacionMatrizPL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idInfoMatriz) {
		jpaRepositorio.deleteById(idInfoMatriz);
		
	}

}
