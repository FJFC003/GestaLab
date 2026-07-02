package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.ClienteC;
import com.prototipo.gestalab.presentacion.dto.request.ClienteCRequestDto;

@Mapper(componentModel = "spring")
public interface IClienteCDtoMapper {
	
	ClienteC toDomain(ClienteCRequestDto dto);
	ClienteCRequestDto toRequestDto(ClienteC clienteCPojo);

}
