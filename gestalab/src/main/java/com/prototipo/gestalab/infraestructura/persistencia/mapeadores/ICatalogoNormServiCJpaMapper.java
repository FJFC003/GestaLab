package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CatalogoNormServiC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoNormServiCEntity;

@Mapper(componentModel = "spring")
public interface ICatalogoNormServiCJpaMapper {
	
	CatalogoNormServiC toDomain(CatalogoNormServiCEntity entity);
	CatalogoNormServiCEntity toEntity(CatalogoNormServiC catalogoNormServiCPojo);

}
