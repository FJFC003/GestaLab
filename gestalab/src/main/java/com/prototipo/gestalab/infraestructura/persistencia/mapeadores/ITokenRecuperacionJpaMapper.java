package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.prototipo.gestalab.dominio.entidades.TokenRecuperacion;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.TokenRecuperacionEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
uses = { IUsuarioJpaMapper.class })
public interface ITokenRecuperacionJpaMapper {

@Mapping(target = "fkUsuario", source = "fkUsuarioEntity")
TokenRecuperacion toDomain(TokenRecuperacionEntity entity);

@Mapping(target = "fkUsuarioEntity", ignore = true)
TokenRecuperacionEntity toEntity(TokenRecuperacion tokenPojo);

}