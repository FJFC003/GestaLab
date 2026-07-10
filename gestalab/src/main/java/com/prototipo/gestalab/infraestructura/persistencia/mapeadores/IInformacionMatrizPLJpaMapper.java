package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionMatrizPLEntity;

@Mapper(componentModel = "spring")
public interface IInformacionMatrizPLJpaMapper {
	
	InformacionMatrizPL toDomain(InformacionMatrizPLEntity entity);
	InformacionMatrizPLEntity toEntity(InformacionMatrizPL infoMatrizPojo);

}
