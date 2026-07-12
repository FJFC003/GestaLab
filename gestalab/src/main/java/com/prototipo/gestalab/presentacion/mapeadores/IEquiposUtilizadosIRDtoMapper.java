package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.presentacion.dto.request.EquiposUtilizadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EquiposUtilizadosIRResponseDto;

@Mapper(componentModel = "spring")
public interface IEquiposUtilizadosIRDtoMapper {
	
	EquiposUtilizadosIR toDomain(EquiposUtilizadosIRRequestDto dto);
	EquiposUtilizadosIRResponseDto toResponseDto(EquiposUtilizadosIR equiposUtilizadosIRPojo);

}
