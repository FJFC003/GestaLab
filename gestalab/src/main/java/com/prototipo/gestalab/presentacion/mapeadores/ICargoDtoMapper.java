package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Cargo;
import com.prototipo.gestalab.presentacion.dto.request.CargoRequestDto;

@Mapper(componentModel = "spring")
public interface ICargoDtoMapper {
	
	Cargo ToDomain(CargoRequestDto dto);
	CargoRequestDto toResponseDto(Cargo cargoPojo);

}
