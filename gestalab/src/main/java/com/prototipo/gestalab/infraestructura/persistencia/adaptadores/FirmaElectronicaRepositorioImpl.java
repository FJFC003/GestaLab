package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.FirmaElectronica;
import com.prototipo.gestalab.dominio.repositorio.IFirmaElectronicaRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.FirmaElectronicaEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IFirmaElectronicaJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IFirmaElectronicaJpaRepositorio;

public class FirmaElectronicaRepositorioImpl implements IFirmaElectronicaRepositorio{
	
	private final IFirmaElectronicaJpaRepositorio jpaRepositorio;
	private final IFirmaElectronicaJpaMapper entityMapper;

	public FirmaElectronicaRepositorioImpl(IFirmaElectronicaJpaRepositorio jpaRepositorio,
			IFirmaElectronicaJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public FirmaElectronica guardar(FirmaElectronica nuevaFirma) {
		FirmaElectronicaEntity entity = entityMapper.toEntity(nuevaFirma);
		FirmaElectronicaEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<FirmaElectronica> buscarPorId(int idFirma) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idFirma).map(entityMapper::toDomain);
	}

	@Override
	public List<FirmaElectronica> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idFirma) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idFirma);
	}

}
