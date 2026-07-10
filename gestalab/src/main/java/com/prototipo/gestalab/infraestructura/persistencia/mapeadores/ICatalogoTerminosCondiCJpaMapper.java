package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CatalogoTerminoCondiC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoTerminosCondiCEntity;

@Mapper(componentModel = "spring")
public interface ICatalogoTerminosCondiCJpaMapper {
	
	CatalogoTerminoCondiC toDomain(CatalogoTerminosCondiCEntity entity);
	CatalogoTerminosCondiCEntity toEntity(CatalogoTerminoCondiC catalogoTerminoCondiCPojo);

}
