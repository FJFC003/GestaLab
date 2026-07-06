package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;
import com.prototipo.gestalab.presentacion.dto.request.OrdenTrabajoOTRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.OrdenTrabajoOTResponseDto;

@Mapper(componentModel = "spring")
public interface IOrdenTrabajoOTDtoMapper {
	
	OrdenTrabajoOT toDomain(OrdenTrabajoOTRequestDto dto);
	OrdenTrabajoOTResponseDto toResponseDto (OrdenTrabajoOT OrdenTrabajoPojo);

}
