package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlanMuestreoPLEntity;

@Mapper(componentModel = "spring", uses = { IDetalleCJpaMapper.class, IEmpleadoJpaMapper.class,
		IEEPPLJpaMapper.class })
public interface IPlanMuestreoPLJpaMapper {
	
	@Mapping(target = "fkDetalleCotizacion", source = "fkDetalleCEntity")
	@Mapping(target = "fkResponsable", source = "fkResponsableEntity")
	PlanMuestreoPL toDomain(PlanMuestreoPLEntity entity);
	
	@Mapping(target = "fkDetalleCEntity", source = "fkDetalleCotizacion")
	@Mapping(target = "fkResponsableEntity", source = "fkResponsable")
	PlanMuestreoPLEntity toEntity(PlanMuestreoPL muestreoPojo);

}
