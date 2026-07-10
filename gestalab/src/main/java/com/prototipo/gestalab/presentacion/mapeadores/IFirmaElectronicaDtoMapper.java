package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.FirmaElectronica;
import com.prototipo.gestalab.presentacion.dto.request.FirmaElectronicaRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.FirmaElectronicaResponseDto;

@Mapper(componentModel = "spring")
public interface IFirmaElectronicaDtoMapper {
	
	FirmaElectronica toDomain(FirmaElectronicaRequestDto dto);
	FirmaElectronicaResponseDto toResponseDto(FirmaElectronica firmaElectronicaPojo);

}
