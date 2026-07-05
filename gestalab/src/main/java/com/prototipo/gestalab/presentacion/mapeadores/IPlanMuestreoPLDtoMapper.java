package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;
import com.prototipo.gestalab.presentacion.dto.request.PlanMuestreoPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.PlanMuestreoPLResponseDto;

@Mapper(componentModel = "spring")
public interface IPlanMuestreoPLDtoMapper {
	
	PlanMuestreoPL toDomain(PlanMuestreoPLRequestDto dto);
	PlanMuestreoPLResponseDto toResponseDto(PlanMuestreoPL muestreoPojo);

}
