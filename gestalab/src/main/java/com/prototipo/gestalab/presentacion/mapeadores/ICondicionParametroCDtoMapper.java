package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CondicionParametroC;
import com.prototipo.gestalab.presentacion.dto.request.CondicionParametroCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CondicionParametroCResponseDto;

@Mapper(componentModel = "spring")
public interface ICondicionParametroCDtoMapper {
	
	CondicionParametroC toDomain(CondicionParametroCRequestDto dto);
	CondicionParametroCResponseDto toResponseDto(CondicionParametroC pojo);

}
