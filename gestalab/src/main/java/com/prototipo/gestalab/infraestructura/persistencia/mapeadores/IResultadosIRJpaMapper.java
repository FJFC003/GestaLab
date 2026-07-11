package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.ResultadosIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ResultadosIREntity;

@Mapper(componentModel = "spring")
public interface IResultadosIRJpaMapper {
	
	ResultadosIR toDomain(ResultadosIREntity entity);
	ResultadosIREntity toEntity(ResultadosIR resultadosIRPojo);

}
