package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.presentacion.dto.request.CotizacionCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CotizacionCResponseDto;

@Mapper(componentModel = "spring", uses = { IClienteCDtoMapper.class, IEmpleadoDtoMapper.class,
		ICatalogoNormServiCDtoMapper.class, ILmpCDtoMapper.class })
public interface ICotizacionCDtoMapper {
	
	@Mapping(target = "fkCliente.idClienteC", source = "fkCliente")
	@Mapping(target = "fkEmpleado.idEmpleado", source = "fkEmpleado")
	@Mapping(target = "fkNormaServicio.idCatalogoNormServi", source = "fkNormaServicio")
	@Mapping(target = "fkLmp.idLmpC", source = "fkLmp")
	CotizacionC toDomain(CotizacionCRequestDto dto);
	
	CotizacionCResponseDto toResponseDto(CotizacionC cotizacionCPojo);

}
