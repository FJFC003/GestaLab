package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;
import com.prototipo.gestalab.presentacion.dto.request.RecursosCronoPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.RecursosCronoPLResponseDto;

@Mapper(componentModel = "spring")
public interface IRecursosCronoPLDtoMapper {
	
	RecursosCronoPL toDomain(RecursosCronoPLRequestDto dto);
	RecursosCronoPLResponseDto toResponseDto(RecursosCronoPL recursosCronoPojo);

}
