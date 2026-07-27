package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;
import com.prototipo.gestalab.presentacion.dto.request.OrdenTrabajoOTRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.OrdenTrabajoOTResponseDto;

@Mapper(componentModel = "spring", uses = { IEmpleadoDtoMapper.class, IPlanMuestreoPLDtoMapper.class })
public interface IOrdenTrabajoOTDtoMapper {
	
	@Mapping(target = "fkResponsableEmision.idEmpleado", source = "fkResponsableEmision")
	@Mapping(target = "fkTecnicoAsignado.idEmpleado", source = "fkTecnicoAsignado")
	@Mapping(target = "fkPlanMuestreo.idPlan", source = "fkPlanMuestreo")
	OrdenTrabajoOT toDomain(OrdenTrabajoOTRequestDto dto);
	OrdenTrabajoOTResponseDto toResponseDto (OrdenTrabajoOT OrdenTrabajoPojo);

}
