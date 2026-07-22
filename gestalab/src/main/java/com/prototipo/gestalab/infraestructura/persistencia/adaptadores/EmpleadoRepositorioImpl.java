package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.dominio.repositorio.IEmpleadoRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEmpleadoJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IAreaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICargoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IEmpleadoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IFirmaElectronicaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuarioJpaRepositorio;

public class EmpleadoRepositorioImpl implements IEmpleadoRepositorio{
	
	private final IEmpleadoJpaRepositorio jpaRepositorio;
	private final IEmpleadoJpaMapper entityMapper;
	private final IAreaJpaRepositorio areaJpaRepositorio;
	private final ICargoJpaRepositorio cargoJpaRepositorio;
	private final IFirmaElectronicaJpaRepositorio firmaJpaRepositorio;
	private final IUsuarioJpaRepositorio usuarioJpaRepositorio;

	public EmpleadoRepositorioImpl(IEmpleadoJpaRepositorio jpaRepositorio, IEmpleadoJpaMapper entityMapper,
			IAreaJpaRepositorio areaJpaRepositorio, ICargoJpaRepositorio cargoJpaRepositorio,
			IFirmaElectronicaJpaRepositorio firmaJpaRepositorio, IUsuarioJpaRepositorio usuarioJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.areaJpaRepositorio = areaJpaRepositorio;
		this.cargoJpaRepositorio = cargoJpaRepositorio;
		this.firmaJpaRepositorio = firmaJpaRepositorio;
		this.usuarioJpaRepositorio = usuarioJpaRepositorio;
	}

	@Override
	public Empleado guardar(Empleado nuevoEmpleado) {
		EmpleadoEntity entity = entityMapper.toEntity(nuevoEmpleado);
		if (nuevoEmpleado.getFkArea() != null) {
			areaJpaRepositorio.findById(nuevoEmpleado.getFkArea().getIdArea())
					.ifPresent(entity::setFkAreaEntity);
		}
		if (nuevoEmpleado.getFkCargo() != null) {
			cargoJpaRepositorio.findById(nuevoEmpleado.getFkCargo().getIdCargo())
					.ifPresent(entity::setFkCargoEntity);
		}
		if (nuevoEmpleado.getFkFirmaElectronica() != null) {
			firmaJpaRepositorio.findById(nuevoEmpleado.getFkFirmaElectronica().getIdFirma())
					.ifPresent(entity::setFkFirmaElectronicaEntity);
		}
		if (nuevoEmpleado.getFkUsuario() != null) {
			usuarioJpaRepositorio.findById(nuevoEmpleado.getFkUsuario().getIdUsuario())
					.ifPresent(entity::setFkUsuarioEntity);
		}
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
