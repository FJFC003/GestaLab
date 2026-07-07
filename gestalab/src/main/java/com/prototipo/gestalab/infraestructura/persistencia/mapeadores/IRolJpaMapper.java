package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.Rol;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RolEntity;

public interface IRolJpaMapper {
	
	Rol toDomain(RolEntity entity);
	RolEntity toEntity(Rol rolPojo);

}
