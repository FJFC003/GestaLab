package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Cargo;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CargoEntity;

@Mapper(componentModel = "spring")
public interface ICargoJpaMapper {
	
	Cargo toDomain(CargoEntity entity);
	CargoEntity toEntity(Cargo cargoPojo);

}
