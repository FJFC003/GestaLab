package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.ProcedimientoMuePLEntity;

public interface IProcedimientoMuePLJpaMapper {
	
	ProcedimientoMuePL toDomain(ProcedimientoMuePLEntity entity);
	ProcedimientoMuePLEntity toEntity(ProcedimientoMuePL procedimientoMuePojo);

}
