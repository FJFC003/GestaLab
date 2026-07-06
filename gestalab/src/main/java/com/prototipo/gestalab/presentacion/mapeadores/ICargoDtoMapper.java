package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Cargo;
import com.prototipo.gestalab.presentacion.dto.request.CargoRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CargoResponseDto;

@Mapper(componentModel = "spring")
public interface ICargoDtoMapper {
	
	Cargo ToDomain(CargoRequestDto dto);
	CargoResponseDto toResponseDto(Cargo cargoPojo);

}
