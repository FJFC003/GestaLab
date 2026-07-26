package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DescripcionServicioC;
import com.prototipo.gestalab.presentacion.dto.request.DescripcionServicioCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DescripcionServicioCResponseDto;

@Mapper(componentModel = "spring")
public interface IDescripcionServicioCDtoMapper {
	
	DescripcionServicioC toDomain(DescripcionServicioCRequestDto dto);
	DescripcionServicioCResponseDto toResponseDto(DescripcionServicioC pojo);

}
