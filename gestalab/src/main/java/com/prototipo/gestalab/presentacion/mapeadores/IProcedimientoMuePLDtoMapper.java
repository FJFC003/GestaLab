package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;
import com.prototipo.gestalab.presentacion.dto.request.ProcedimientoMuePLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.ProcedimientoMuePLResponseDto;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLDtoMapper.class })
public interface IProcedimientoMuePLDtoMapper {
	
	@Mapping(target = "fkPlanMuestreo.idPlan", source = "fkPlanMuestreo")
	ProcedimientoMuePL toDomain(ProcedimientoMuePLRequestDto dto);
	ProcedimientoMuePLResponseDto toResponseDto(ProcedimientoMuePL procedimientoMuePojo);

}
