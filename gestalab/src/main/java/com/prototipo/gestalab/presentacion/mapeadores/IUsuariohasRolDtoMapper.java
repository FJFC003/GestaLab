package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;
import com.prototipo.gestalab.presentacion.dto.request.UsuariohasRolRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.UsuariohasRolResponseDto;

@Mapper(componentModel = "spring")
public interface IUsuariohasRolDtoMapper {
	
	UsuariohasRol toDomain(UsuariohasRolRequestDto dto);
	UsuariohasRolResponseDto toResponseDto(UsuariohasRol usuariohasRolPojo);

}
