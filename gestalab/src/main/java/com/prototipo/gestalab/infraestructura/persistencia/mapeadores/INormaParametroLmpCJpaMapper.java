package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.NormaParametroLmpC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.NormaParametroLmpCEntity;

@Mapper(componentModel = "spring", uses = { ICatalogoNormServiCJpaMapper.class, ICatalogoParametrosCJpaMapper.class,
		ILmpCJpaMapper.class })
public interface INormaParametroLmpCJpaMapper {
	
	@Mapping(target = "fkNorma", source = "fkNormaEntity")
	@Mapping(target = "fkParametro", source = "fkParametroEntity")
	@Mapping(target = "fkLmp", source = "fkLmpEntity")
	NormaParametroLmpC toDomain(NormaParametroLmpCEntity entity);

	@Mapping(target = "fkNormaEntity", source = "fkNorma")
	@Mapping(target = "fkParametroEntity", source = "fkParametro")
	@Mapping(target = "fkLmpEntity", source = "fkLmp")
	NormaParametroLmpCEntity toEntity(NormaParametroLmpC normapojo);

}
