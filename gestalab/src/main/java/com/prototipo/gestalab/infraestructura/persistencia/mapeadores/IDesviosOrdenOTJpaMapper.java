package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.DesviosOrdenOT;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DesviosOrdenOTEntity;

@Mapper(componentModel = "spring", uses = { IOrdenTrabajoOTJpaMapper.class })
public interface IDesviosOrdenOTJpaMapper {
	
	@Mapping(target = "fkOrdenTrabajo", source = "fkOrdenTrabajoEntity")
	DesviosOrdenOT toDomain(DesviosOrdenOTEntity entity);
	
	@Mapping(target = "fkOrdenTrabajoEntity", source = "fkOrdenTrabajo")
	DesviosOrdenOTEntity toEntity(DesviosOrdenOT desviosOrdenOTPojo);

}
