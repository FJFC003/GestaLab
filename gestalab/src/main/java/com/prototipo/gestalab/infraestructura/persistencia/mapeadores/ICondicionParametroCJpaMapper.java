package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CondicionParametroC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CondicionParametroCEntity;

@Mapper(componentModel = "spring")
public interface ICondicionParametroCJpaMapper {
	
	CondicionParametroC toDomain(CondicionParametroCEntity entity);
	CondicionParametroCEntity toEntity(CondicionParametroC pojo);

}
