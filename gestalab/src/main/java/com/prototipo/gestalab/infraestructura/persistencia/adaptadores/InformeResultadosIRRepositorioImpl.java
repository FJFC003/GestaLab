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
	public InformeResultadosIR guardar(InformeResultadosIR nuevoInformeResultadosIR) {
		InformeResultadosIREntity entity = entityMapper.toEntity(nuevoInformeResultadosIR);
		InformeResultadosIREntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<InformeResultadosIR> buscarPorId(int idInforme) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idInforme).map(entityMapper::toDomain);
	}

	@Override
	public List<InformeResultadosIR> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idInforme) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idInforme);
	}

}
