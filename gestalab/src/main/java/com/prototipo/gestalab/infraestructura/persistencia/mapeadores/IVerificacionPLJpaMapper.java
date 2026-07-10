package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.VerificacionPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.VerificacionPLEntity;

@Mapper(componentModel = "spring")
public interface IVerificacionPLJpaMapper {
	
	VerificacionPL toDomain(VerificacionPLEntity entity);
	VerificacionPLEntity toEntity(VerificacionPL verificacionPojo);

}
