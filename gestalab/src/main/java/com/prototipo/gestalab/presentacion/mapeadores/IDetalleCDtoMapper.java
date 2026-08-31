package com.prototipo.gestalab.presentacion.mapeadores;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.dominio.entidades.DetalleParametroC;
import com.prototipo.gestalab.presentacion.dto.request.DetalleCRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.DetalleParametroCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DetalleCResponseDto;

@Mapper(componentModel = "spring", uses = { ICatalogoParametroCDtoMapper.class, ILmpCDtoMapper.class,
		IDescripcionServicioCDtoMapper.class, IPlazoEntregaCDtoMapper.class, ITipoTomaMuestraCDtoMapper.class })
public interface IDetalleCDtoMapper {

	@Mapping(target = "fkCotizacion.idCotizacionC", source = "fkCotizacion")
	@Mapping(target = "fkDescripcionServicio.idDescripcionServicioC", source = "fkDescripcionServicio")
	@Mapping(target = "fkPlazoEntrega.idPlazoEntregaC", source = "fkPlazoEntrega")
	@Mapping(target = "fkTipoTomaMuestra.idTipoTomaMuestraC", source = "fkTipoTomaMuestra")
	@Mapping(target = "listaParametros", source = "listaParametros")
	DetalleC toDomain(DetalleCRequestDto dto);

	@Mapping(target = "fkParametro.idParametroC", source = "fkParametro")
	@Mapping(target = "fkLmp.idLmpC", source = "fkLmp")
	DetalleParametroC toDomainParametro(DetalleParametroCRequestDto dto);

	List<DetalleParametroC> toDomainParametros(List<DetalleParametroCRequestDto> dtos);

	DetalleCResponseDto toResponseDto(DetalleC detalleCPojo);

}
