package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.OrdenTrabajoOTEntity;

@Mapper(componentModel = "spring", uses = { IEmpleadoJpaMapper.class, IPlanMuestreoPLJpaMapper.class })
public interface IOrdenTrabajoOTJpaMapper {
	
	@Mapping(target = "fkResponsableEmision", source = "fkResponsableEmisionEntity")
	@Mapping(target = "fkTecnicoAsignado", source = "fkTecnicoAsignadoEntity")
	@Mapping(target = "fkPlanMuestreo", source = "fkPlanMuestreoEntity")
	OrdenTrabajoOT toDomain(OrdenTrabajoOTEntity entity);
	
	@Mapping(target = "fkResponsableEmisionEntity", source = "fkResponsableEmision")
	@Mapping(target = "fkTecnicoAsignadoEntity", source = "fkTecnicoAsignado")
	@Mapping(target = "fkPlanMuestreoEntity", source = "fkPlanMuestreo")
	OrdenTrabajoOTEntity toEntity(OrdenTrabajoOT ordenTrabajoPojo);

}
