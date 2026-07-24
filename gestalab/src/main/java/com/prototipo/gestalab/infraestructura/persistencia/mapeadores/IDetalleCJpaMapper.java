package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleCEntity;

@Mapper(componentModel = "spring", uses = { ICotizacionCJpaMapper.class, ICatalogoParametrosCJpaMapper.class, ICatalogoNormServiCJpaMapper.class })
public interface IDetalleCJpaMapper {

	
	@Mapping(target = "fkCotizacion", source = "fkCotizacionCEntity")
	@Mapping(target = "fkParametro", source = "fkCatalogoParametroEntity")
	@Mapping(target = "fkNormaServicio", source = "fkCatalogoNormServiEntity")
	DetalleC toDomain(DetalleCEntity entity);
	
	@Mapping(target = "fkCotizacionCEntity", source = "fkCotizacion")
	@Mapping(target = "fkCatalogoParametroEntity", source = "fkParametro")
	@Mapping(target = "fkCatalogoNormServiEntity", source = "fkNormaServicio")
	DetalleCEntity toEntity(DetalleC detalleCPojo);
	
}
