package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.ClienteC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ClienteCEntity;

@Mapper(componentModel = "spring")
public interface IClienteCJpaMapper {
	
	ClienteC toDomain(ClienteCEntity entity);
	ClienteCEntity toEntity(ClienteC clienteCPojo);
	
}
