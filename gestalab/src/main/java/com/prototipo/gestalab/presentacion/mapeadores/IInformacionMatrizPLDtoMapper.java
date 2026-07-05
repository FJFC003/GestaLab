package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;
import com.prototipo.gestalab.presentacion.dto.request.InformacionMatrizPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformacionMatrizPLResponseDto;

@Mapper(componentModel = "spring")
public interface IInformacionMatrizPLDtoMapper {
	
	InformacionMatrizPL toDomain(InformacionMatrizPLRequestDto dto);
	InformacionMatrizPLResponseDto toResponseDto(InformacionMatrizPL infoMatrizPojo);

}
