package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.VerificacionPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.VerificacionPLEntity;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLJpaMapper.class })
public interface IVerificacionPLJpaMapper {
	
	@Mapping(target = "fkPlanMuestreo", source = "fkPlanMuestreoEntity")
	VerificacionPL toDomain(VerificacionPLEntity entity);
	
	@Mapping(target = "fkPlanMuestreoEntity", source = "fkPlanMuestreo")
	VerificacionPLEntity toEntity(VerificacionPL verificacionPojo);

}
