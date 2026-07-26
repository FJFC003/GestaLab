package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.PlazoEntregaC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlazoEntregaCEntity;

@Mapper(componentModel = "spring")
public interface IPlazoEntregaCJpaMapper {
	
	PlazoEntregaC toDomain(PlazoEntregaCEntity entity);
	PlazoEntregaCEntity toEntity(PlazoEntregaC plazopojo);

}
