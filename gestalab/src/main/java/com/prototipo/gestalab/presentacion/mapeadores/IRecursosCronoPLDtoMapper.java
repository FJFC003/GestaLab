package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;
import com.prototipo.gestalab.presentacion.dto.request.RecursosCronoPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.RecursosCronoPLResponseDto;

@Mapper(componentModel = "spring", uses = { IEmpleadoDtoMapper.class })
public interface IRecursosCronoPLDtoMapper {
	
	@Mapping(target = "fkTecnico.idEmpleado", source = "fkTecnico")
	RecursosCronoPL toDomain(RecursosCronoPLRequestDto dto);
	
	RecursosCronoPLResponseDto toResponseDto(RecursosCronoPL recursosCronoPojo);

}
