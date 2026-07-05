package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.TipoTomaFreHoraPLEntity;

public interface ITipoTomaFreHoraPLJpaMapper {
	
	TipoTomaFreHoraPL toDomain(TipoTomaFreHoraPLEntity entity);
	TipoTomaFreHoraPLEntity toEntity(TipoTomaFreHoraPL tomaFreHoraPojo);

}
