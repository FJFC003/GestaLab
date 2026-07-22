package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.presentacion.dto.request.EmpleadoRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EmpleadoResponseDto;

@Mapper(componentModel = "spring", uses = { IAreaDtoMapper.class, ICargoDtoMapper.class,
		IFirmaElectronicaDtoMapper.class, IUsuarioDtoMapper.class })
public interface IEmpleadoDtoMapper {
	
	@Mapping(target = "fkArea.idArea", source = "fkArea")
	@Mapping(target = "fkCargo.idCargo", source = "fkCargo")
	@Mapping(target = "fkFirmaElectronica.idFirma", source = "fkFirmaElectronica")
	@Mapping(target = "fkUsuario.idUsuario", source = "fkUsuario")
	Empleado toDomain(EmpleadoRequestDto dto);
	EmpleadoResponseDto toResponseDto(Empleado empleadoPojo);

}
