package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.EEPPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EEPPLEntity;

public interface IEEPPLJpaMapper {
	
	EEPPL toDomain(EEPPLEntity entity);
	EEPPLEntity toEntity(EEPPL eepplPojo);

}
