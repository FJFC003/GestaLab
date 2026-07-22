package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.Empleado;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EmpleadoEntity;

@Mapper(componentModel = "spring", uses = { IAreaJpaMapper.class, ICargoJpaMapper.class,
		IFirmaElectronicaJpaMapper.class, IUsuarioJpaMapper.class })

public interface IEmpleadoJpaMapper {
	
	@Mapping(target = "fkArea", source = "fkAreaEntity")
	@Mapping(target = "fkCargo", source = "fkCargoEntity")
	@Mapping(target = "fkFirmaElectronica", source = "fkFirmaElectronicaEntity")
	@Mapping(target = "fkUsuario", source = "fkUsuarioEntity")
	Empleado toDomain(EmpleadoEntity entity);
	
	@Mapping(target = "fkAreaEntity", source = "fkArea")
	@Mapping(target = "fkCargoEntity", source = "fkCargo")
	@Mapping(target = "fkFirmaElectronicaEntity", source = "fkFirmaElectronica")
	@Mapping(target = "fkUsuarioEntity", source = "fkUsuario")
	EmpleadoEntity toEntity(Empleado empleadoPojo);

}
