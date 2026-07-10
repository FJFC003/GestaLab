package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoParametrosCEntity;

@Mapper(componentModel = "spring")
public interface ICatalogoParametrosCJpaMapper {
	
	CatalogoParametroC toDomain(CatalogoParametrosCEntity entity);
	CatalogoParametrosCEntity toEntity(CatalogoParametroC catalogoParametroCPojo);

}
