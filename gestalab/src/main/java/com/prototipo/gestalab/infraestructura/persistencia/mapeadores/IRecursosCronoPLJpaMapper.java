package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RecursosCronoPLEntity;

@Mapper(componentModel = "spring", uses = { IEmpleadoJpaMapper.class, IPlanMuestreoPLJpaMapper.class })
public interface IRecursosCronoPLJpaMapper {
	
	@Mapping(target = "fkTecnico", source = "fkTecnicoEntity")
	@Mapping(target = "fkPlanMuestreo", source = "fkPlanMuestreoEntity")
	RecursosCronoPL toDomain(RecursosCronoPLEntity entity);
	
	@Mapping(target = "fkTecnicoEntity", source = "fkTecnico")
	@Mapping(target = "fkPlanMuestreoEntity", source = "fkPlanMuestreo")
	RecursosCronoPLEntity toEntity(RecursosCronoPL recursosCronoPojo);

}
