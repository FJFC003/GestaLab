package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.dominio.repositorio.IEmpleadoRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEmpleadoJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IEmpleadoJpaRepositorio;

public class EmpleadoRepositorioImpl implements IEmpleadoRepositorio{
	
	private final IEmpleadoJpaRepositorio jpaRepositorio;
	private final IEmpleadoJpaMapper entityMapper;
	
	

	public EmpleadoRepositorioImpl(IEmpleadoJpaRepositorio jpaRepositorio, IEmpleadoJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Empleado guardar(Empleado nuevoEmpleado) {
		EmpleadoEntity entity = entityMapper.toEntity(nuevoEmpleado);
		EmpleadoEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<Empleado> buscarPorId(int idEmpleado) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idEmpleado).map(entityMapper::toDomain);
	}

	@Override
	public List<Empleado> ListarTodo() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idEmpleado) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idEmpleado);
	}

}
