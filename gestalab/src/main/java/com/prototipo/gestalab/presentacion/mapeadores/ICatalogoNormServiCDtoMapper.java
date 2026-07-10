package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CatalogoNormServiC;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoNormServiCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoNormServiCResponseDto;

@Mapper(componentModel = "spring")
public interface ICatalogoNormServiCDtoMapper {
	
	CatalogoNormServiC toDomain(CatalogoNormServiCRequestDto dto);
	CatalogoNormServiCResponseDto toResponseDto(CatalogoNormServiC catalogoNormServiCPojo);

}
