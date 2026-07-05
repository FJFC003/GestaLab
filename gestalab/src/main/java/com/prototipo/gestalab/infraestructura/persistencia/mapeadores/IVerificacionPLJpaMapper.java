package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.VerificacionPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.VerificacionPLEntity;

public interface IVerificacionPLJpaMapper {
	
	VerificacionPL toDomain(VerificacionPLEntity entity);
	VerificacionPLEntity toEntity(VerificacionPL verificacionPojo);

}
