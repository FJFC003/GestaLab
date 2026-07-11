package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EquiposUtilizadosIREntity;

@Mapper(componentModel = "spring")
public interface IEquiposUtilizadosIRJpaMapper {
	
	EquiposUtilizadosIR toDomain(EquiposUtilizadosIREntity entity);
	EquiposUtilizadosIREntity toEntity(EquiposUtilizadosIR equiposUtilizadosIRPojo);

}
