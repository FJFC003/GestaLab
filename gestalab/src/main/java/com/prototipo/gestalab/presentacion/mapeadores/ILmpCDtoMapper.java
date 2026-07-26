package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.LmpC;
import com.prototipo.gestalab.presentacion.dto.request.LmpCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.LmpCResponseDto;

@Mapper(componentModel = "spring")
public interface ILmpCDtoMapper {
	
	LmpC toDomain(LmpCRequestDto dto);
	LmpCResponseDto toResponseDto(LmpC lmppojo);

}
