package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;
import com.prototipo.gestalab.presentacion.dto.request.ParametroAnalizarPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.ParametroAnalizarPLResponseDto;

@Mapper(componentModel = "spring")
public interface IParametroAnalizarPLDtoMapper {
	
	ParametroAnalizarPL toDomain(ParametroAnalizarPLRequestDto dto);
	ParametroAnalizarPLResponseDto toResponseDto(ParametroAnalizarPL analizarPojo);

}
