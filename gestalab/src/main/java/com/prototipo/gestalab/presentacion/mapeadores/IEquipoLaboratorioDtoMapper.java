package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.EquipoLaboratorio;
import com.prototipo.gestalab.presentacion.dto.request.EquipoLaboratorioRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EquipoLaboratorioResponseDto;

@Mapper(componentModel = "spring")
public interface IEquipoLaboratorioDtoMapper {
	
	EquipoLaboratorio toDomain(EquipoLaboratorioRequestDto dto);
	EquipoLaboratorioResponseDto toResponseDto(EquipoLaboratorio equipoLaboratorioPojo);

}
