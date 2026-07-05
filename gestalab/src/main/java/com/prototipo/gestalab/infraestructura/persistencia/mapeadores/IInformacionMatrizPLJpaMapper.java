package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionMatrizPLEntity;

public interface IInformacionMatrizPLJpaMapper {
	
	InformacionMatrizPL toDomain(InformacionMatrizPLEntity entity);
	InformacionMatrizPLEntity toEntity(InformacionMatrizPL infoMatrizPojo);

}
