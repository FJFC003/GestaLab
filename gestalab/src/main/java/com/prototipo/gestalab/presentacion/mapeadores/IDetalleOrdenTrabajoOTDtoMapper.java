package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DetalleOrdenTrabajoOT;
import com.prototipo.gestalab.presentacion.dto.request.DetalleOrdenTrabajoOTRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DetalleOrdenTrabajoOTResponseDto;

@Mapper(componentModel = "spring")
public interface IDetalleOrdenTrabajoOTDtoMapper {
	
	DetalleOrdenTrabajoOT ToDomain(DetalleOrdenTrabajoOTRequestDto dto);
	DetalleOrdenTrabajoOTResponseDto toResponseDto(DetalleOrdenTrabajoOT detalleOrdenTrabajoOTPojo);

}
