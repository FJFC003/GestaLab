package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.presentacion.dto.request.UsuarioRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.UsuarioResponseDto;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {
	
	Usuario toDomain(UsuarioRequestDto dto);
	UsuarioResponseDto toResponseDto(Usuario usuarioPojo);

}
