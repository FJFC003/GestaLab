package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.presentacion.dto.request.EmpleadoRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EmpleadoResponseDto;

@Mapper(componentModel = "spring")
public interface IEmpleadoDtoMapper {
	
	Empleado toDomain(EmpleadoRequestDto dto);
	EmpleadoResponseDto toResponseDto(Empleado empleadoPojo);

}
