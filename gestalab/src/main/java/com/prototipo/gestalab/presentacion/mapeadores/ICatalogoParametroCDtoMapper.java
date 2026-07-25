package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoParametroCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoParametroCResponseDto;

@Mapper(componentModel = "spring", uses = { ICondicionParametroCDtoMapper.class })
public interface ICatalogoParametroCDtoMapper {
	
	@Mapping(target = "fkCondicionParametro.idCondicionParametroC", source = "fkCondicionParametro")
	CatalogoParametroC toDomain(CatalogoParametroCRequestDto dto);
	CatalogoParametroCResponseDto toResponseDto(CatalogoParametroC catalogoParametroCPojo);

}
