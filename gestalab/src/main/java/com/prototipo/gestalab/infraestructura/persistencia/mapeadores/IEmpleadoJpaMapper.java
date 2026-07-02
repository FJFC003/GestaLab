package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EmpleadoEntity;

@Mapper(componentModel = "spring")
public interface IEmpleadoJpaMapper {
	
	Empleado toDomain(EmpleadoEntity entity);
	EmpleadoEntity toEntity(Empleado empleadoPojo);

}
