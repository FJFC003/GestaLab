package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;
import com.prototipo.gestalab.dominio.repositorio.IRecursosCronoPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RecursosCronoPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IRecursosCronoPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IRecursosCronoPLJpaRepositorio;

public class RecursosCronoPLRepositorioImpl implements IRecursosCronoPLRepositorio{

	private final IRecursosCronoPLJpaRepositorio jpaRepositorio;
	private final IRecursosCronoPLJpaMapper entityMapper;
	
	
	public RecursosCronoPLRepositorioImpl(IRecursosCronoPLJpaRepositorio jpaRepositorio,
			IRecursosCronoPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public RecursosCronoPL guardar(RecursosCronoPL nuevoRecursosCronoPL) {
		RecursosCronoPLEntity entity = entityMapper.toEntity(nuevoRecursosCronoPL);
		RecursosCronoPLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<RecursosCronoPL> buscarPorId(int idRecursos) {
		return jpaRepositorio.findById(idRecursos).map(entityMapper::toDomain);
	}

	@Override
	public List<RecursosCronoPL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idRecursos) {
		jpaRepositorio.deleteById(idRecursos);
		
	}

}
