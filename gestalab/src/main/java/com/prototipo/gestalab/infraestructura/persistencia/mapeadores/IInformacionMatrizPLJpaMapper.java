package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionMatrizPLEntity;

@Mapper(componentModel = "spring", uses = { IPlanMuestreoPLJpaMapper.class })
public interface IInformacionMatrizPLJpaMapper {
	
	@Mapping(target = "fkPlanMuestreo", source = "fkPlanMuestreoEntity")
	InformacionMatrizPL toDomain(InformacionMatrizPLEntity entity);
	
	@Mapping(target = "fkPlanMuestreoEntity", source = "fkPlanMuestreo")
	InformacionMatrizPLEntity toEntity(InformacionMatrizPL infoMatrizPojo);

}
