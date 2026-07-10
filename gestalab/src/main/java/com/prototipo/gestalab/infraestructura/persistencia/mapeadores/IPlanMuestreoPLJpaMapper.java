package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlanMuestreoPLEntity;

@Mapper(componentModel = "spring")
public interface IPlanMuestreoPLJpaMapper {
	
	PlanMuestreoPL toDomain(PlanMuestreoPLEntity entity);
	PlanMuestreoPLEntity toEntity(PlanMuestreoPL muestreoPojo);

}
