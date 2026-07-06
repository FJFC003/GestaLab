package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleCEntity;

@Mapper(componentModel = "spring")
public interface IDetalleCJpaMapper {

	DetalleC toDomain(DetalleCEntity entity);
	DetalleCEntity toEntity(DetalleC detalleCPojo);
	
}
