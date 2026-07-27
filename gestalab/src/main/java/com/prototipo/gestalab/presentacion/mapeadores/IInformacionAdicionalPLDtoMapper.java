package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;
import com.prototipo.gestalab.presentacion.dto.request.InformacionAdicionalPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformacionAdicionalPLResponseDto;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLDtoMapper.class })
public interface IInformacionAdicionalPLDtoMapper {
	
	@Mapping(target = "fkPlanMuestreo.idPlan", source = "fkPlanMuestreo")
	InformacionAdicionalPL toDomain(InformacionAdicionalPLRequestDto dto);
	InformacionAdicionalPLResponseDto toResponseDto(InformacionAdicionalPL informacionPojo);

}
