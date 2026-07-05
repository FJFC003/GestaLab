package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RecursosCronoPLEntity;

public interface IRecursosCronoPLJpaMapper {
	
	RecursosCronoPL toDomain(RecursosCronoPLEntity entity);
	RecursosCronoPLEntity toEntity(RecursosCronoPL recursosCronoPojo);

}
