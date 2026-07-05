package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ParametroAnalizarPLEntity;

public interface IParametroAnalizarPLJpaMapper {
	
	ParametroAnalizarPL toDomain(ParametroAnalizarPLEntity entity);
	ParametroAnalizarPLEntity toEntity(ParametroAnalizarPL analizarPojo);

}
