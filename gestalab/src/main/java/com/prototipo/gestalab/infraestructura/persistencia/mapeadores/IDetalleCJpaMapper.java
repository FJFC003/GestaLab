package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.dominio.entidades.DetalleParametroC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleParametroCEntity;

@Mapper(componentModel = "spring", uses = { ICotizacionCJpaMapper.class, ICatalogoParametrosCJpaMapper.class,
		ILmpCJpaMapper.class, IDescripcionServicioCJpaMapper.class, IPlazoEntregaCJpaMapper.class,
		ITipoTomaMuestraCJpaMapper.class })
public interface IDetalleCJpaMapper {

	@Mapping(target = "fkCotizacion", source = "fkCotizacionCEntity")
	@Mapping(target = "fkDescripcionServicio", source = "fkDescripcionServicioEntity")
	@Mapping(target = "fkPlazoEntrega", source = "fkPlazoEntregaEntity")
	@Mapping(target = "fkTipoTomaMuestra", source = "fkTipoTomaMuestraEntity")
	@Mapping(target = "listaParametros", source = "listaParametros")
	DetalleC toDomain(DetalleCEntity entity);

	// Los hijos se construyen en el repositorio, donde se resuelven las claves
	// foraneas contra la base; si MapStruct los mapeara aqui llegarian entidades
	// sueltas sin el padre asignado.
	@Mapping(target = "fkCotizacionCEntity", source = "fkCotizacion")
	@Mapping(target = "fkDescripcionServicioEntity", source = "fkDescripcionServicio")
	@Mapping(target = "fkPlazoEntregaEntity", source = "fkPlazoEntrega")
	@Mapping(target = "fkTipoTomaMuestraEntity", source = "fkTipoTomaMuestra")
	@Mapping(target = "listaParametros", ignore = true)
	@Mapping(target = "listaPlanes", ignore = true)
	DetalleCEntity toEntity(DetalleC detalleCPojo);

	// Metodo propio para el elemento de la lista: corta el ciclo padre-hijo
	// porque el dominio del hijo no lleva referencia de vuelta al detalle.
	@Mapping(target = "fkParametro", source = "fkCatalogoParametroEntity")
	@Mapping(target = "fkLmp", source = "fkLmpEntity")
	DetalleParametroC toDomainParametro(DetalleParametroCEntity entity);

	List<DetalleParametroC> toDomainParametros(List<DetalleParametroCEntity> entidades);

}
