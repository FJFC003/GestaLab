package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;
import com.prototipo.gestalab.presentacion.dto.request.InformacionMatrizPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformacionMatrizPLResponseDto;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLDtoMapper.class })
public interface IInformacionMatrizPLDtoMapper {
	
	@Mapping(target = "fkPlanMuestreo.idPlan", source = "fkPlanMuestreo")
	InformacionMatrizPL toDomain(InformacionMatrizPLRequestDto dto);
	
	InformacionMatrizPLResponseDto toResponseDto(InformacionMatrizPL infoMatrizPojo);

}
