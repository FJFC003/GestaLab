package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.ResultadosIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ResultadosIREntity;

@Mapper(componentModel = "spring", uses = { IInformeResultadosIRJpaMapper.class })
public interface IResultadosIRJpaMapper {
	
	@Mapping(target = "fkInforme", source = "fkInformeEntity")
	ResultadosIR toDomain(ResultadosIREntity entity);
	
	@Mapping(target = "fkInformeEntity", source = "fkInforme")
	ResultadosIREntity toEntity(ResultadosIR resultadosIRPojo);

}
