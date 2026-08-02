package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EquiposUtilizadosIREntity;

@Mapper(componentModel = "spring", uses = { IInformeResultadosIRJpaMapper.class })
public interface IEquiposUtilizadosIRJpaMapper {
	
	@Mapping(target = "fkInforme", source = "fkInformeEntity")
	EquiposUtilizadosIR toDomain(EquiposUtilizadosIREntity entity);
	
	@Mapping(target = "fkInformeEntity", source = "fkInforme")
	EquiposUtilizadosIREntity toEntity(EquiposUtilizadosIR equiposUtilizadosIRPojo);

}
