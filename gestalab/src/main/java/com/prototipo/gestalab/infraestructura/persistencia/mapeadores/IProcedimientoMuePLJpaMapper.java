package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ProcedimientoMuePLEntity;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLJpaMapper.class })
public interface IProcedimientoMuePLJpaMapper {
	
	@Mapping(target = "fkPlanMuestreo", source = "fkPlanMuestreoEntity")
	ProcedimientoMuePL toDomain(ProcedimientoMuePLEntity entity);
	
	@Mapping(target = "fkPlanMuestreoEntity", source = "fkPlanMuestreo")
	ProcedimientoMuePLEntity toEntity(ProcedimientoMuePL procedimientoMuePojo);

}
