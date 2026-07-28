package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.DetalleOrdenTrabajoOT;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleOrdenTrabajoOTEntity;

@Mapper(componentModel = "spring", uses = { IOrdenTrabajoOTJpaMapper.class })
public interface IDetalleOrdenTrabajoOTJpaMapper {
	
	@Mapping(target = "fkOrdenTrabajo", source = "fkOrdenTrabajoEntity")
	DetalleOrdenTrabajoOT toDomain(DetalleOrdenTrabajoOTEntity entity);
	
	@Mapping(target = "fkOrdenTrabajoEntity", source = "fkOrdenTrabajo")
	DetalleOrdenTrabajoOTEntity toEntity(DetalleOrdenTrabajoOT detalleOrdenTrabajoOTPojo);

}
