package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.presentacion.dto.request.CondicionAmbientalIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CondicionAmbientalIRResponseDto;

@Mapper(componentModel = "spring")
public interface ICondicionAmbientalIRDtoMapper {
	
	@Mapping(target = "fkInforme.idInforme", source = "fkInforme")
	CondicionAmbientalIR toDomain(CondicionAmbientalIRRequestDto dto);
	CondicionAmbientalIRResponseDto toResponseDto(CondicionAmbientalIR condicionAmbientalIRPojo);

}
