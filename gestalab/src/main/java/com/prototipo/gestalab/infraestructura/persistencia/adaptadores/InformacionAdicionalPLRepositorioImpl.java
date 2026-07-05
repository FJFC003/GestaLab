package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;
import com.prototipo.gestalab.dominio.repositorio.IInformacionAdicionalPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionAdicionalPLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IInformacionAdicionalPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IInformacionAdicionalPLJpaRepositorio;

public class InformacionAdicionalPLRepositorioImpl implements IInformacionAdicionalPLRepositorio{
	
	private final IInformacionAdicionalPLJpaRepositorio jpaRepositorio;
	private final IInformacionAdicionalPLJpaMapper entityMapper;
	
	

	public InformacionAdicionalPLRepositorioImpl(IInformacionAdicionalPLJpaRepositorio jpaRepositorio,
			IInformacionAdicionalPLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public InformacionAdicionalPL guardar(InformacionAdicionalPL nuevoInfoAdi) {
		InformacionAdicionalPLEntity entity = entityMapper.toEntity(nuevoInfoAdi);
		InformacionAdicionalPLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<InformacionAdicionalPL> buscarPorId(int idInformacion) {
		return jpaRepositorio.findById(idInformacion).map(entityMapper::toDomain);
	}

	@Override
	public List<InformacionAdicionalPL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idInformacion) {
		jpaRepositorio.deleteById(idInformacion);
	}

}
