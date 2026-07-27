package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;
import com.prototipo.gestalab.presentacion.dto.request.TipoTomaFreHoraPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.TipoTomaFreHoraPLResponseDto;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLDtoMapper.class })
public interface ITipoTomaFreHoraPLDtoMapper {
	
	@Mapping(target = "fkPlanMuestreo.idPlan", source = "fkPlanMuestreo")
	TipoTomaFreHoraPL toDomain(TipoTomaFreHoraPLRequestDto dto);
	TipoTomaFreHoraPLResponseDto toResponseDto(TipoTomaFreHoraPL tomaFreHoraPojo);

}
