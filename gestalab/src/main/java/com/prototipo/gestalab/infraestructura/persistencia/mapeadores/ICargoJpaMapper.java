package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.prototipo.gestalab.dominio.entidades.Cargo;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CargoEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICargoJpaMapper {
	
	Cargo toDomain(CargoEntity entity);
	CargoEntity toEntity(Cargo cargoPojo);

}
