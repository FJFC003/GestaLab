package com.prototipo.gestalab.presentacion.mapeadores;

import com.prototipo.gestalab.dominio.entidades.Rol;
import com.prototipo.gestalab.presentacion.dto.request.RolRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.RolResponseDto;

public interface IRolDtoMapper {
	
	Rol toDomain(RolRequestDto dto);
	RolResponseDto toResponseDto(Rol rolPojo);

}
