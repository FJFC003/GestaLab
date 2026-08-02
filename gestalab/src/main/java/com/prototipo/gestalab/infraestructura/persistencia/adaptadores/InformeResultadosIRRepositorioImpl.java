package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.dominio.repositorio.IInformeResultadosIRRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformeResultadosIREntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IInformeResultadosIRJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IInformeResultadosIRJpaRepositorio;

public class InformeResultadosIRRepositorioImpl implements IInformeResultadosIRRepositorio{
	
	private final IInformeResultadosIRJpaRepositorio jpaRepositorio;
	private final IInformeResultadosIRJpaMapper entityMapper;

	public InformeResultadosIRRepositorioImpl(IInformeResultadosIRJpaRepositorio jpaRepositorio,
			IInformeResultadosIRJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public InformeResultadosIR guardar(InformeResultadosIR nuevoInforme) {
		InformeResultadosIREntity entity = entityMapper.toEntity(nuevoInforme);
		InformeResultadosIREntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<InformeResultadosIR> buscarPorId(int idInforme) {
		return jpaRepositorio.findById(idInforme).map(entityMapper::toDomain);
	}

	@Override
	public List<InformeResultadosIR> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idInforme) {
		jpaRepositorio.deleteById(idInforme);
	}

	@Override
	public Optional<InformeResultadosIR> buscarPorOrden(int idOT) {
		return jpaRepositorio.findByFkOrdenTrabajoEntity_IdOT(idOT).map(entityMapper::toDomain);
	}

}
