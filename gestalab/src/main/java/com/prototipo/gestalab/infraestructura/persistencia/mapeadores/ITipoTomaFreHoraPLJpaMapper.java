package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.TipoTomaFreHoraPLEntity;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLJpaMapper.class })
public interface ITipoTomaFreHoraPLJpaMapper {
	
	@Mapping(target = "fkPlanMuestreo", source = "fkPlanMuestreoEntity")
	TipoTomaFreHoraPL toDomain(TipoTomaFreHoraPLEntity entity);
	
	@Mapping(target = "fkPlanMuestreoEntity", source = "fkPlanMuestreo")
	TipoTomaFreHoraPLEntity toEntity(TipoTomaFreHoraPL tomaFreHoraPojo);

}
