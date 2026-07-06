package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DesviosOrdenOT;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DesviosOrdenOTEntity;

@Mapper(componentModel = "spring")
public interface IDesviosOrdenOTJpaMapper {
	DesviosOrdenOT toDomain(DesviosOrdenOTEntity entity);
	DesviosOrdenOTEntity toEntity(DesviosOrdenOT desviosOrdenOTPojo);

}
