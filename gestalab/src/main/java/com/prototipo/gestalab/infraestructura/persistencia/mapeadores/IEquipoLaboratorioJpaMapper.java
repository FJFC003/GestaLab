package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.EquipoLaboratorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EquipoLaboratorioEntity;

@Mapper(componentModel = "spring")
public interface IEquipoLaboratorioJpaMapper {
	
	EquipoLaboratorio toDomain(EquipoLaboratorioEntity entity);
	EquipoLaboratorioEntity toEntity(EquipoLaboratorio equipoLaboratorioPojo);

}
