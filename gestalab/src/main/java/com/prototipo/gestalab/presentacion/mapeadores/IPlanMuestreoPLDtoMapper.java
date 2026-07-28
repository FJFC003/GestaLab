package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;
import com.prototipo.gestalab.presentacion.dto.request.PlanMuestreoPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.PlanMuestreoPLResponseDto;

@Mapper(componentModel = "spring", uses = { IEmpleadoDtoMapper.class, IDetalleCDtoMapper.class,
		IEEPPLDtoMapper.class })
public interface IPlanMuestreoPLDtoMapper {
	
	@Mapping(target = "fkResponsable.idEmpleado", source = "fkResponsable")
	@Mapping(target = "fkDetalleCotizacion.idDetalleC", source = "fkDetalleCotizacion")
	@Mapping(target = "fkeep.idEEP", source = "fkeep")
	PlanMuestreoPL toDomain(PlanMuestreoPLRequestDto dto);
	PlanMuestreoPLResponseDto toResponseDto(PlanMuestreoPL muestreoPojo);

}
