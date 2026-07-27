package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.VerificacionPL;
import com.prototipo.gestalab.presentacion.dto.request.VerificacionPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.VerificacionPLResponseDto;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLDtoMapper.class })
public interface IVerificacionPLDtoMapper {
	
	@Mapping(target = "fkPlanMuestreo.idPlan", source = "fkPlanMuestreo")
	VerificacionPL toDomain(VerificacionPLRequestDto dto);
	VerificacionPLResponseDto toResponseDto(VerificacionPL verificacionPojo);

}
