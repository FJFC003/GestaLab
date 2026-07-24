package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CotizacionCEntity;

@Mapper(componentModel = "spring", uses = { IClienteCJpaMapper.class, ICatalogoTerminosCondiCJpaMapper.class, IEmpleadoJpaMapper.class })
public interface ICotizacionCJpaMapper {
	
	@Mapping(target = "fkCliente", source = "fkClienteCEntity")
	@Mapping(target = "fkTerminoCondicion", source = "fkCatalogoTerminoCondiEntity")
	@Mapping(target = "fkEmpleado", source = "fkEmpleadoEntity")
	CotizacionC toDomain(CotizacionCEntity entity);
	
	@Mapping(target = "fkClienteCEntity", source = "fkCliente")
	@Mapping(target = "fkCatalogoTerminoCondiEntity", source = "fkTerminoCondicion")
	@Mapping(target = "fkEmpleadoEntity", source = "fkEmpleado")
	CotizacionCEntity toEntity(CotizacionC cotizacionCPojo);

}
