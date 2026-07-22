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
		// Área
				if (nuevoEmpleado.getFkArea() != null && nuevoEmpleado.getFkArea().getIdArea() > 0) {
					entity.setFkAreaEntity(
							areaJpaRepositorio.findById(nuevoEmpleado.getFkArea().getIdArea()).orElse(null));
				} else {
					entity.setFkAreaEntity(null);
				}

				// Cargo
				if (nuevoEmpleado.getFkCargo() != null && nuevoEmpleado.getFkCargo().getIdCargo() > 0) {
					entity.setFkCargoEntity(
							cargoJpaRepositorio.findById(nuevoEmpleado.getFkCargo().getIdCargo()).orElse(null));
				} else {
					entity.setFkCargoEntity(null);
				}

				// Firma Electrónica
				if (nuevoEmpleado.getFkFirmaElectronica() != null && nuevoEmpleado.getFkFirmaElectronica().getIdFirma() > 0) {
					entity.setFkFirmaElectronicaEntity(
							firmaJpaRepositorio.findById(nuevoEmpleado.getFkFirmaElectronica().getIdFirma()).orElse(null));
				} else {
					entity.setFkFirmaElectronicaEntity(null);
				}

				// Usuario
				if (nuevoEmpleado.getFkUsuario() != null && nuevoEmpleado.getFkUsuario().getIdUsuario() > 0) {
					entity.setFkUsuarioEntity(
							usuarioJpaRepositorio.findById(nuevoEmpleado.getFkUsuario().getIdUsuario()).orElse(null));
				} else {
					entity.setFkUsuarioEntity(null);
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
