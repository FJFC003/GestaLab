package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ParametroAnalizarPLEntity;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLJpaMapper.class })
public interface IParametroAnalizarPLJpaMapper {
	
	@Mapping(target = "fkPlanMuestreo", source = "fkPlanMuestreoEntity")
	ParametroAnalizarPL toDomain(ParametroAnalizarPLEntity entity);
	
	@Mapping(target = "fkPlanMuestreoEntity", source = "fkPlanMuestreo")
	ParametroAnalizarPLEntity toEntity(ParametroAnalizarPL analizarPojo);

}
