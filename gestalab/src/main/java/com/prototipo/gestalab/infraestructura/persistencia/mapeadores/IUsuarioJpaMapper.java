package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioJpaMapper {
	
	Usuario toDomain(UsuarioEntity entity);
	UsuarioEntity toEntity(Usuario usuarioPojo);

}
