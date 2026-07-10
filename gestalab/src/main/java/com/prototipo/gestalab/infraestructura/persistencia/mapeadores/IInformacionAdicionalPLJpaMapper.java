package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionAdicionalPLEntity;

@Mapper(componentModel = "spring")
public interface IInformacionAdicionalPLJpaMapper {
	
	InformacionAdicionalPL toDomain(InformacionAdicionalPLEntity entity);
	InformacionAdicionalPLEntity toEntity(InformacionAdicionalPL informacionPojo);

}
