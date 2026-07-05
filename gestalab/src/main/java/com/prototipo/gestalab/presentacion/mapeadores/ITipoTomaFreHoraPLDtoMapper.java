package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;
import com.prototipo.gestalab.presentacion.dto.request.TipoTomaFreHoraPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.TipoTomaFreHoraPLResponseDto;

@Mapper(componentModel = "spring")
public interface ITipoTomaFreHoraPLDtoMapper {
	TipoTomaFreHoraPL toDomain(TipoTomaFreHoraPLRequestDto dto);
	TipoTomaFreHoraPLResponseDto toResponseDto(TipoTomaFreHoraPL tomaFreHoraPojo);

}
