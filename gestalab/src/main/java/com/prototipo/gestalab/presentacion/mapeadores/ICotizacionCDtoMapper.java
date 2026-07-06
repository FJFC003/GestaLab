package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.presentacion.dto.request.CotizacionCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CotizacionCResponseDto;

@Mapper(componentModel = "spring")
public interface ICotizacionCDtoMapper {
	
	CotizacionC toDomain(CotizacionCRequestDto dto);
	CotizacionCResponseDto  toResponseDto(CotizacionC  cotizacionCPojo);

}
