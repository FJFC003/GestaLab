package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;
import com.prototipo.gestalab.presentacion.dto.request.InformacionAdicionalPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformacionAdicionalPLResponseDto;

@Mapper(componentModel = "spring")
public interface IInformacionAdicionalPLDtoMapper {
	
	InformacionAdicionalPL toDomain(InformacionAdicionalPLRequestDto dto);
	InformacionAdicionalPLResponseDto toResponseDto(InformacionAdicionalPL informacionPojo);

}
