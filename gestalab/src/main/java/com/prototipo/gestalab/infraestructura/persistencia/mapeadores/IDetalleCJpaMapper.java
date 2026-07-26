package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleCEntity;

@Mapper(componentModel = "spring", uses = { ICotizacionCJpaMapper.class, ICatalogoParametrosCJpaMapper.class,
		ILmpCJpaMapper.class, IDescripcionServicioCJpaMapper.class, IPlazoEntregaCJpaMapper.class })
public interface IDetalleCJpaMapper {

	@Mapping(target = "fkCotizacion", source = "fkCotizacionCEntity")
	@Mapping(target = "fkParametro", source = "fkCatalogoParametroEntity")
	@Mapping(target = "fkLmp", source = "fkLmpEntity")
	@Mapping(target = "fkDescripcionServicio", source = "fkDescripcionServicioEntity")
	@Mapping(target = "fkPlazoEntrega", source = "fkPlazoEntregaEntity")
	DetalleC toDomain(DetalleCEntity entity);

	@Mapping(target = "fkCotizacionCEntity", source = "fkCotizacion")
	@Mapping(target = "fkCatalogoParametroEntity", source = "fkParametro")
	@Mapping(target = "fkLmpEntity", source = "fkLmp")
	@Mapping(target = "fkDescripcionServicioEntity", source = "fkDescripcionServicio")
	@Mapping(target = "fkPlazoEntregaEntity", source = "fkPlazoEntrega")
	DetalleCEntity toEntity(DetalleC detalleCPojo);
	
}
