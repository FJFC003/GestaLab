package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlanMuestreoPLEntity;

public interface IPlanMuestreoPLJpaMapper {
	
	PlanMuestreoPL toDomain(PlanMuestreoPLEntity entity);
	PlanMuestreoPLEntity toEntity(PlanMuestreoPL muestreoPojo);

}
