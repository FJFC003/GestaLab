package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CatalogoTerminoCondiC;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoTerminoCondiCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoTerminoCondiCResponseDto;

@Mapper(componentModel = "spring")
public interface ICatalogoTerminoCondiCDtoMapper {
	
	CatalogoTerminoCondiC toDomain(CatalogoTerminoCondiCRequestDto dto);
	CatalogoTerminoCondiCResponseDto toResponseDto(CatalogoTerminoCondiC terminoCondiCPojo);

}
