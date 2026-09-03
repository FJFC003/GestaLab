package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformeResultadosIREntity;

@Mapper(componentModel = "spring",
uses = { IDatosLaboratorioIRJpaMapper.class, IOrdenTrabajoOTJpaMapper.class, ILmpCJpaMapper.class })
public interface IInformeResultadosIRJpaMapper {
	
	@Mapping(target = "fkDatosLaboratorio", source = "fkDatosLaboratorioEntity")
	@Mapping(target = "fkOrdenTrabajo", source = "fkOrdenTrabajoEntity")
	@Mapping(target = "fkLmp", source = "fkLmpEntity")
	InformeResultadosIR toDomain(InformeResultadosIREntity entity);
	
	@Mapping(target = "fkDatosLaboratorioEntity", source = "fkDatosLaboratorio")
	@Mapping(target = "fkOrdenTrabajoEntity", source = "fkOrdenTrabajo")
	@Mapping(target = "fkLmpEntity", source = "fkLmp")
	InformeResultadosIREntity toEntity(InformeResultadosIR informeResultadosIRPojo);

}
