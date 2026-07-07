package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.UsuariohasRolEntity;

@Mapper(componentModel = "spring")
public interface IUsuariohasRolJpaMapper {
	
	UsuariohasRol toDomain(UsuariohasRolEntity entity);
	UsuariohasRolEntity toEntity(UsuariohasRol usuariohasRolPojo);

}
