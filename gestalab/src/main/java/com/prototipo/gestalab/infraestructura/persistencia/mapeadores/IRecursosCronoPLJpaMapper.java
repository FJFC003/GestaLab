package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RecursosCronoPLEntity;

@Mapper(componentModel = "spring")
public interface IRecursosCronoPLJpaMapper {
	
	RecursosCronoPL toDomain(RecursosCronoPLEntity entity);
	RecursosCronoPLEntity toEntity(RecursosCronoPL recursosCronoPojo);

}
