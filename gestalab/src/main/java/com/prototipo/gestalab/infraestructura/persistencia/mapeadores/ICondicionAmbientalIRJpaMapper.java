package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CondicionAmbientalIREntity;

@Mapper(componentModel = "spring", uses = { IInformeResultadosIRJpaMapper.class })

public interface ICondicionAmbientalIRJpaMapper {
	
	@Mapping(target = "fkInforme", source = "fkInformeEntity")
	CondicionAmbientalIR toDomain(CondicionAmbientalIREntity entity);
	
	@Mapping(target = "fkInformeEntity", source = "fkInforme")
	CondicionAmbientalIREntity toEntity(CondicionAmbientalIR condicionAmbientalIRPojo);

}
