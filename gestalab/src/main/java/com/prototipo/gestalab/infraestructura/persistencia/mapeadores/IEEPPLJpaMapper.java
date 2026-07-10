package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.EEPPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EEPPLEntity;

@Mapper(componentModel = "spring")
public interface IEEPPLJpaMapper {
	
	EEPPL toDomain(EEPPLEntity entity);
	EEPPLEntity toEntity(EEPPL eepplPojo);

}
