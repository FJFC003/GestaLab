package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DetalleOrdenTrabajoOT;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleOrdenTrabajoOTEntity;

@Mapper(componentModel = "spring")
public interface IDetalleOrdenTrabajoOTJpaMapper {
	
	DetalleOrdenTrabajoOT toDomain(DetalleOrdenTrabajoOTEntity entity);
	DetalleOrdenTrabajoOTEntity toEntity(DetalleOrdenTrabajoOT detalleOrdenTrabajoOTPojo);

}
