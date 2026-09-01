package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CatalogoPlanPL;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoPlanPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoPlanPLResponseDto;

@Mapper(componentModel = "spring")
public interface ICatalogoPlanPLDtoMapper {

	CatalogoPlanPL toDomain(CatalogoPlanPLRequestDto dto);
	CatalogoPlanPLResponseDto toResponseDto(CatalogoPlanPL pojo);

}
