package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.prototipo.gestalab.dominio.entidades.Rol;
import com.prototipo.gestalab.presentacion.dto.request.RolRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.RolResponseDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRolDtoMapper {
	
	Rol toDomain(RolRequestDto dto);
	RolResponseDto toResponseDto(Rol rolPojo);

}
