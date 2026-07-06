package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.presentacion.dto.request.DetalleCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DetalleCResponseDto;

@Mapper(componentModel = "spring")
public interface IDetalleCDtoMapper {
	
	DetalleC toDomain(DetalleCRequestDto dto);
	DetalleCResponseDto toResponseDto(DetalleC detalleCPojo);

}
