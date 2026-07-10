package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.prototipo.gestalab.dominio.entidades.Rol;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RolEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRolJpaMapper {
	
	Rol toDomain(RolEntity entity);
	RolEntity toEntity(Rol rolPojo);

}
