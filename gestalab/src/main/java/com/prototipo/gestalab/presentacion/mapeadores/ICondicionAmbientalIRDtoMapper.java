package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.presentacion.dto.request.CondicionAmbientalIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CondicionAmbientalIRResponseDto;

@Mapper(componentModel = "spring")
public interface ICondicionAmbientalIRDtoMapper {
	
	CondicionAmbientalIR toDomain(CondicionAmbientalIRRequestDto dto);
	CondicionAmbientalIRResponseDto toResponseDto(CondicionAmbientalIR condicionAmbientalIRPojo);

}
