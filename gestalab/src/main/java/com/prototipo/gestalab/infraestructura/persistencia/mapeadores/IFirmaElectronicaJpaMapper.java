package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.prototipo.gestalab.dominio.entidades.FirmaElectronica;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.FirmaElectronicaEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IFirmaElectronicaJpaMapper {
	
	FirmaElectronica toDomain(FirmaElectronicaEntity entity);
	FirmaElectronicaEntity toEntity(FirmaElectronica firmaElectronicaPojo);

}
