package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionAdicionalPLEntity;

public interface IInformacionAdicionalPLJpaMapper {
	
	InformacionAdicionalPL toDomain(InformacionAdicionalPLEntity entity);
	InformacionAdicionalPLEntity toEntity(InformacionAdicionalPL informacionPojo);

}
