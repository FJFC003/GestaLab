package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CatalogoPlanPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoPlanPLEntity;

@Mapper(componentModel = "spring")
public interface ICatalogoPlanPLJpaMapper {

	CatalogoPlanPL toDomain(CatalogoPlanPLEntity entity);
	CatalogoPlanPLEntity toEntity(CatalogoPlanPL catalogoPojo);

}
