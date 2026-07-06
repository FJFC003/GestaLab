package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DesviosOrdenOT;
import com.prototipo.gestalab.presentacion.dto.request.DesviosOrdenOTRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DesviosOrdenOTResponseDto;

@Mapper(componentModel = "spring")
public interface IDesviosOrdenOTDtoMapper {
	
	DesviosOrdenOT ToDomain(DesviosOrdenOTRequestDto dto);
	DesviosOrdenOTResponseDto toResponseDto(DesviosOrdenOT desviosOrdenOTPojo);

}
