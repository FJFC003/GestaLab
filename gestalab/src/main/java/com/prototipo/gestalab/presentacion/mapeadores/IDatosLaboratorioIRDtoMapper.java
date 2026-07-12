package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.DatosLaboratorioIR;
import com.prototipo.gestalab.presentacion.dto.request.DatosLaboratorioIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DatosLaboratorioIRResponseDto;

@Mapper(componentModel = "spring")
public interface IDatosLaboratorioIRDtoMapper {
	
	DatosLaboratorioIR toDomain(DatosLaboratorioIRRequestDto dto);
	DatosLaboratorioIRResponseDto toResponseDto(DatosLaboratorioIR datosLaboratorioIRPojo);

}
