package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformeResultadosIREntity;

@Mapper(componentModel = "spring")
public interface IInformeResultadosIRJpaMapper {
	
	InformeResultadosIR toDomain(InformeResultadosIREntity entity);
	InformeResultadosIREntity toEntity(InformeResultadosIR informeResultadosIRPojo);

}
