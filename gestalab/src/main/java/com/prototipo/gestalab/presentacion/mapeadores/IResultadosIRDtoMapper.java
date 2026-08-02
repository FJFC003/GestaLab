package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.ResultadosIR;
import com.prototipo.gestalab.presentacion.dto.request.ResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.ResultadosIRResponseDto;

@Mapper(componentModel = "spring")
public interface IResultadosIRDtoMapper {
	
	@Mapping(target = "fkInforme.idInforme", source = "fkInforme")
	ResultadosIR toDomain(ResultadosIRRequestDto dto);
	ResultadosIRResponseDto toResponseDto(ResultadosIR resultadosIRPojo);

}
