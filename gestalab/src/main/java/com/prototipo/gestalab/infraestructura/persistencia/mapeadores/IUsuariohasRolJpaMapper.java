package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.UsuariohasRolEntity;

@Mapper(componentModel = "spring", uses = { IUsuarioJpaMapper.class, IRolJpaMapper.class })
public interface IUsuariohasRolJpaMapper {
	
	@Mapping(target = "fkUsuario", source = "fkUsuarioEntity")
	@Mapping(target = "fkRol", source = "fkRolEntity")
	UsuariohasRol toDomain(UsuariohasRolEntity entity);
	
	@Mapping(target = "fkUsuarioEntity", source = "fkUsuario")
	@Mapping(target = "fkRolEntity", source = "fkRol")
	UsuariohasRolEntity toEntity(UsuariohasRol usuariohasRolPojo);

}
