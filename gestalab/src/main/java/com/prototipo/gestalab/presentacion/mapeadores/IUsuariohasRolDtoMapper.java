package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;
import com.prototipo.gestalab.presentacion.dto.request.UsuariohasRolRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.UsuariohasRolResponseDto;

@Mapper(componentModel = "spring", uses = { IUsuarioDtoMapper.class, IRolDtoMapper.class })
public interface IUsuariohasRolDtoMapper {
	
	@Mapping(target = "fkUsuario.idUsuario", source = "fkUsuario")
	@Mapping(target = "fkRol.idRol", source = "fkRol")
	
	UsuariohasRol toDomain(UsuariohasRolRequestDto dto);
	UsuariohasRolResponseDto toResponseDto(UsuariohasRol usuariohasRolPojo);

}
