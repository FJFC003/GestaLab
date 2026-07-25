package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoParametrosCEntity;

@Mapper(componentModel = "spring", uses = { ICondicionParametroCJpaMapper.class })
public interface ICatalogoParametrosCJpaMapper {
	
	@Mapping(target = "fkCondicionParametro", source = "fkCondicionParametroEntity")
	CatalogoParametroC toDomain(CatalogoParametrosCEntity entity);
	
	@Mapping(target = "fkCondicionParametroEntity", source = "fkCondicionParametro")
	CatalogoParametrosCEntity toEntity(CatalogoParametroC catalogoParametroCPojo);

}
