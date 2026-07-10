package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.VerificacionPL;
import com.prototipo.gestalab.presentacion.dto.request.VerificacionPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.VerificacionPLResponseDto;

@Mapper(componentModel = "spring")
public interface IVerificacionPLDtoMapper {
	
	VerificacionPL toDomain(VerificacionPLRequestDto dto);
	VerificacionPLResponseDto toResponseDto(VerificacionPL verificacionPojo);

}
