package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.OrdenTrabajoOTEntity;

@Mapper(componentModel = "spring")
public interface IOrdenTrabajoOTJpaMapper {
	
	OrdenTrabajoOT toDomain(OrdenTrabajoOTEntity entity);
	OrdenTrabajoOTEntity toEntity(OrdenTrabajoOT ordenTrabajoPojo);

}
