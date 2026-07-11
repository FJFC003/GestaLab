package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DatosLaboratorioIR;
import com.prototipo.gestalab.dominio.repositorio.IDatosLaboratorioIRRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DatosLaboratorioIREntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDatosLaboratorioIRJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IDatosLaboratorioIRJpaRepositorio;

public class DatosLaboratorioIRRepositorioImpl implements IDatosLaboratorioIRRepositorio{
	
	private final IDatosLaboratorioIRJpaRepositorio jpaRepositorio;
	private final IDatosLaboratorioIRJpaMapper entityMapper;
	
	public DatosLaboratorioIRRepositorioImpl(IDatosLaboratorioIRJpaRepositorio jpaRepositorio,
			IDatosLaboratorioIRJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DatosLaboratorioIR guardar(DatosLaboratorioIR nuevoDatosLaboratorioIR) {
		DatosLaboratorioIREntity entity = entityMapper.toEntity(nuevoDatosLaboratorioIR);
		DatosLaboratorioIREntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<DatosLaboratorioIR> buscarPorId(int idDatos) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idDatos).map(entityMapper::toDomain);
	}

	@Override
	public List<DatosLaboratorioIR> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDatos) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idDatos);
	}

}
