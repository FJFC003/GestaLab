package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DescripcionServicioC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DescripcionServicioCEntity;

@Mapper(componentModel = "spring")
public interface IDescripcionServicioCJpaMapper {
	
	DescripcionServicioC toDomain(DescripcionServicioCEntity entity);
	DescripcionServicioCEntity toEntity(DescripcionServicioC descripcionpojo);

}
