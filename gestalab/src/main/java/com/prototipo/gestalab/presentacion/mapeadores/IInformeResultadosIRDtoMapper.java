package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.presentacion.dto.request.InformeResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformeResultadosIRResponseDto;

@Mapper(componentModel = "spring")
public interface IInformeResultadosIRDtoMapper {
	
	InformeResultadosIR toDomain(InformeResultadosIRRequestDto dto);
	InformeResultadosIRResponseDto toResponseDto(InformeResultadosIR informeResultadosIRPojo);

}
