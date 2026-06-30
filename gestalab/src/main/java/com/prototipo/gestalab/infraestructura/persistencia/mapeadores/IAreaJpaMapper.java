package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Area;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.AreaEntity;

@Mapper(componentModel = "spring")
public interface IAreaJpaMapper {
	
	Area toDomain(AreaEntity entity);
	AreaEntity toEntity(Area areaPojo);

}
