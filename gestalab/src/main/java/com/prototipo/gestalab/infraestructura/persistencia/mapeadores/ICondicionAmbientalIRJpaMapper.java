package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CondicionAmbientalIREntity;

@Mapper(componentModel = "spring")
public interface ICondicionAmbientalIRJpaMapper {
	
	CondicionAmbientalIR toDomain(CondicionAmbientalIREntity entity);
	CondicionAmbientalIREntity toEntity(CondicionAmbientalIR condicionAmbientalIRPojo);

}
