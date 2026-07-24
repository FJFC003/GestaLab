package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.presentacion.dto.request.DetalleCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DetalleCResponseDto;

@Mapper(componentModel = "spring", uses = { ICatalogoParametroCDtoMapper.class, ICatalogoNormServiCDtoMapper.class })
public interface IDetalleCDtoMapper {
	
	@Mapping(target = "fkCotizacion.idCotizacionC", source = "fkCotizacion")
	@Mapping(target = "fkParametro.idParametroC", source = "fkParametro")
	@Mapping(target = "fkNormaServicio.idCatalogoNormServi", source = "fkNormaServicio")
	DetalleC toDomain(DetalleCRequestDto dto);
	DetalleCResponseDto toResponseDto(DetalleC detalleCPojo);

}
