package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;
import com.prototipo.gestalab.presentacion.dto.request.ParametroAnalizarPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.ParametroAnalizarPLResponseDto;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLDtoMapper.class })
public interface IParametroAnalizarPLDtoMapper {
	@Mapping(target = "fkPlanMuestreo.idPlan", source = "fkPlanMuestreo")
	ParametroAnalizarPL toDomain(ParametroAnalizarPLRequestDto dto);
	
	ParametroAnalizarPLResponseDto toResponseDto(ParametroAnalizarPL analizarPojo);

}
