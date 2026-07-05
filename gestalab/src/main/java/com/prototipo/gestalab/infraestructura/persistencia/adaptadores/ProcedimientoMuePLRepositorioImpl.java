package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;
import com.prototipo.gestalab.dominio.repositorio.IProcedimientoMuePLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ProcedimientoMuePLEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IProcedimientoMuePLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IProcedimientoMuePLJpaRepositorio;

public class ProcedimientoMuePLRepositorioImpl implements IProcedimientoMuePLRepositorio{
	
	private final IProcedimientoMuePLJpaRepositorio jpaRepositorio;
	private final IProcedimientoMuePLJpaMapper entityMapper;
	
	

	public ProcedimientoMuePLRepositorioImpl(IProcedimientoMuePLJpaRepositorio jpaRepositorio,
			IProcedimientoMuePLJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ProcedimientoMuePL guardar(ProcedimientoMuePL nuevoProMue) {
		ProcedimientoMuePLEntity entity = entityMapper.toEntity(nuevoProMue);
		ProcedimientoMuePLEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<ProcedimientoMuePL> buscarPorId(int idProcedimiento) {
		return jpaRepositorio.findById(idProcedimiento).map(entityMapper::toDomain);
	}

	@Override
	public List<ProcedimientoMuePL> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idProcedimiento) {
		jpaRepositorio.deleteById(idProcedimiento);
		
	}

}
