package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ProcedimientoMuePLEntity;

@Mapper(componentModel = "spring")
public interface IProcedimientoMuePLJpaMapper {
	
	ProcedimientoMuePL toDomain(ProcedimientoMuePLEntity entity);
	ProcedimientoMuePLEntity toEntity(ProcedimientoMuePL procedimientoMuePojo);

}
