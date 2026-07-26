package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.LmpC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.LmpCEntity;

@Mapper(componentModel = "spring")
public interface ILmpCJpaMapper {
	
	LmpC toDomain(LmpCEntity entity);
	LmpCEntity toEntity(LmpC lmppojo);

}
