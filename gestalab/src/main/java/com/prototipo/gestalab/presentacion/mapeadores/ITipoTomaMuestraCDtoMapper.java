package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.TipoTomaMuestraC;
import com.prototipo.gestalab.presentacion.dto.request.TipoTomaMuestraCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.TipoTomaMuestraCResponseDto;

@Mapper(componentModel = "spring")
public interface ITipoTomaMuestraCDtoMapper {

	TipoTomaMuestraC toDomain(TipoTomaMuestraCRequestDto dto);
	TipoTomaMuestraCResponseDto toResponseDto(TipoTomaMuestraC pojo);

}
