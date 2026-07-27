package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionAdicionalPLEntity;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLJpaMapper.class })
public interface IInformacionAdicionalPLJpaMapper {
	
	@Mapping(target = "fkPlanMuestreo", source = "fkPlanMuestreoEntity")
	InformacionAdicionalPL toDomain(InformacionAdicionalPLEntity entity);
	
	@Mapping(target = "fkPlanMuestreoEntity", source = "fkPlanMuestreo")
	InformacionAdicionalPLEntity toEntity(InformacionAdicionalPL informacionPojo);

}
