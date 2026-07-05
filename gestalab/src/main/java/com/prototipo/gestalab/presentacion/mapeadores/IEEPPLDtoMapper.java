package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.EEPPL;
import com.prototipo.gestalab.presentacion.dto.request.EEPPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EEPPLResponseDto;

@Mapper(componentModel = "spring")
public interface IEEPPLDtoMapper {
	
	EEPPL toDomain(EEPPLRequestDto dto);
	EEPPLResponseDto toResponseDto(EEPPL eepplPojo);

}
