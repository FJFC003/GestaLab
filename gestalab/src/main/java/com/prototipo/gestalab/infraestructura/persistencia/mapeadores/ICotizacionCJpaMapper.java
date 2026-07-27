package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CotizacionCEntity;

@Mapper(componentModel = "spring", uses = { IClienteCJpaMapper.class, IEmpleadoJpaMapper.class,
		ICatalogoNormServiCJpaMapper.class, ILmpCJpaMapper.class })
public interface ICotizacionCJpaMapper {
	
	@Mapping(target = "fkCliente", source = "fkClienteCEntity")
	@Mapping(target = "fkEmpleado", source = "fkEmpleadoEntity")
	@Mapping(target = "fkNormaServicio", source = "fkCatalogoNormServiEntity")
	@Mapping(target = "fkLmp", source = "fkLmpEntity")
	@Mapping(target = "fkEmpleadoAprueba", source = "fkEmpleadoApruebaEntity")
	CotizacionC toDomain(CotizacionCEntity entity);
	
	@Mapping(target = "fkClienteCEntity", source = "fkCliente")
	@Mapping(target = "fkEmpleadoEntity", source = "fkEmpleado")
	@Mapping(target = "fkCatalogoNormServiEntity", source = "fkNormaServicio")
	@Mapping(target = "fkLmpEntity", source = "fkLmp")
	@Mapping(target = "fkEmpleadoApruebaEntity", source = "fkEmpleadoAprueba")
	CotizacionCEntity toEntity(CotizacionC cotizacionCPojo);

}
