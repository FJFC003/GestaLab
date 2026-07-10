package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ParametroAnalizarPLEntity;

@Mapper(componentModel = "spring")
public interface IParametroAnalizarPLJpaMapper {
	
	ParametroAnalizarPL toDomain(ParametroAnalizarPLEntity entity);
	ParametroAnalizarPLEntity toEntity(ParametroAnalizarPL analizarPojo);

}
