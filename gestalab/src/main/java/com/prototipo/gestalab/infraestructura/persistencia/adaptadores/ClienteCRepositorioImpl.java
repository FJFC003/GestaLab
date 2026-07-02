package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.ClienteC;
import com.prototipo.gestalab.dominio.repositorio.IClienteCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ClienteCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IClienteCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IClienteCJpaRepositorio;

public class ClienteCRepositorioImpl implements IClienteCRepositorio{
	
	private final IClienteCJpaRepositorio jpaRepositorio;
	private final IClienteCJpaMapper entityMapper;
	
	

	public ClienteCRepositorioImpl(IClienteCJpaRepositorio jpaRepositorio, IClienteCJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ClienteC guardar(ClienteC nuevaCliente) {
		ClienteCEntity entity = entityMapper.toEntity(nuevaCliente);
		ClienteCEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<ClienteC> buscarPorId(int idClienteC) {
		return jpaRepositorio.findById(idClienteC).map(entityMapper :: toDomain);
	}

	@Override
	public List<ClienteC> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idClienteC) {
		jpaRepositorio.deleteById(idClienteC);
		
	}

}
