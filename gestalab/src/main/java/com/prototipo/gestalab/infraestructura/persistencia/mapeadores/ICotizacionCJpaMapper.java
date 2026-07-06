package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CotizacionCEntity;

@Mapper(componentModel = "spring")
public interface ICotizacionCJpaMapper {
	
	CotizacionC toDomain(CotizacionCEntity entity);
	CotizacionCEntity toEntity(CotizacionC cotizacionCPojo);

}
