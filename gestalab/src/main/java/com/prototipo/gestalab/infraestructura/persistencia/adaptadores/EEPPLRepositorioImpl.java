package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.EEPPL;
import com.prototipo.gestalab.dominio.repositorio.IEEPPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EEPPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEEPPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IEEPPLJpaRepositorio;

public class EEPPLRepositorioImpl implements IEEPPLRepositorio{
	
	private final IEEPPLJpaRepositorio jpaRepositorio;
	private final IEEPPLJpaMapper entityMapper;
	
	

	public EEPPLRepositorioImpl(IEEPPLJpaRepositorio jpaRepositorio, IEEPPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public EEPPL guardar(EEPPL nuevoEEPPL) {
		EEPPLEntity entity = entityMapper.toEntity(nuevoEEPPL);
		EEPPLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<EEPPL> buscarPorId(int idEEP) {
		return jpaRepositorio.findById(idEEP).map(entityMapper :: toDomain);
	}

	@Override
	public List<EEPPL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper :: toDomain).toList();
	}

	@Override
	public void eliminar(int idEEP) {
		jpaRepositorio.deleteById(idEEP);
		
	}

}
