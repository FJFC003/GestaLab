package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.TipoTomaMuestraC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.TipoTomaMuestraCEntity;

@Mapper(componentModel = "spring")
public interface ITipoTomaMuestraCJpaMapper {

	TipoTomaMuestraC toDomain(TipoTomaMuestraCEntity entity);
	TipoTomaMuestraCEntity toEntity(TipoTomaMuestraC tipoTomaMuestraPojo);

}
