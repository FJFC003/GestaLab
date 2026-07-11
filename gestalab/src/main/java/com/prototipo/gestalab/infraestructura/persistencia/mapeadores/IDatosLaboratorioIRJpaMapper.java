package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DatosLaboratorioIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DatosLaboratorioIREntity;

@Mapper(componentModel = "spring")
public interface IDatosLaboratorioIRJpaMapper {
	
	DatosLaboratorioIR toDomain(DatosLaboratorioIREntity entity);
	DatosLaboratorioIREntity toEntity(DatosLaboratorioIR datosLaboratorioIRPojo);

}
