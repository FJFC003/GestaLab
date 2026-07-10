package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoParametroCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoParametroCResponseDto;

@Mapper(componentModel = "spring")
public interface ICatalogoParametroCDtoMapper {
	
	CatalogoParametroC toDomain(CatalogoParametroCRequestDto dto);
	CatalogoParametroCResponseDto toResponseDto(CatalogoParametroC catalogoParametroCPojo);

}
