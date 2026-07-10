package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.TipoTomaFreHoraPLEntity;

@Mapper(componentModel = "spring")
public interface ITipoTomaFreHoraPLJpaMapper {
	
	TipoTomaFreHoraPL toDomain(TipoTomaFreHoraPLEntity entity);
	TipoTomaFreHoraPLEntity toEntity(TipoTomaFreHoraPL tomaFreHoraPojo);

}
