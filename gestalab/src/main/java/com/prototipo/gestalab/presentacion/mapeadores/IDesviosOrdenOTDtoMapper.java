package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.DesviosOrdenOT;
import com.prototipo.gestalab.presentacion.dto.request.DesviosOrdenOTRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DesviosOrdenOTResponseDto;

@Mapper(componentModel = "spring")
public interface IDesviosOrdenOTDtoMapper {
	
	@Mapping(target = "fkOrdenTrabajo.idOT", source = "fkOrdenTrabajo")
	DesviosOrdenOT ToDomain(DesviosOrdenOTRequestDto dto);
	DesviosOrdenOTResponseDto toResponseDto(DesviosOrdenOT desviosOrdenOTPojo);

}
