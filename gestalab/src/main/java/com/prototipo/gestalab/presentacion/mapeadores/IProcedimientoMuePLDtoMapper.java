package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;


import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;
import com.prototipo.gestalab.presentacion.dto.request.ProcedimientoMuePLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.ProcedimientoMuePLResponseDto;

@Mapper(componentModel = "spring")
public interface IProcedimientoMuePLDtoMapper {
	
	ProcedimientoMuePL toDomain(ProcedimientoMuePLRequestDto dto);
	ProcedimientoMuePLResponseDto toResponseDto(ProcedimientoMuePL procedimientoMuePojo);

}
