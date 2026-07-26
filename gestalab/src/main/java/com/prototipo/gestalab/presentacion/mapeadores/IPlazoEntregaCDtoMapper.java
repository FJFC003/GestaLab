package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.PlazoEntregaC;
import com.prototipo.gestalab.presentacion.dto.request.PlazoEntregaCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.PlazoEntregaCResponseDto;

@Mapper(componentModel = "spring")
public interface IPlazoEntregaCDtoMapper {
	
	PlazoEntregaC toDomain(PlazoEntregaCRequestDto dto);
	PlazoEntregaCResponseDto toResponseDto(PlazoEntregaC pojo);

}
