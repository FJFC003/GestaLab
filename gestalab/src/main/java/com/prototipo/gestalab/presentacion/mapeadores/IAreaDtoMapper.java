package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Area;
import com.prototipo.gestalab.presentacion.dto.request.AreaRequestDto;

@Mapper(componentModel = "spring")
public interface IAreaDtoMapper {
	
	Area toDomain(AreaRequestDto dto);
	AreaRequestDto toResponseDto(Area areaPojo);

}
