package com.prototipo.gestalab.infraestructura.persistencia.mapeadores;

import com.prototipo.gestalab.dominio.entidades.Login;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.LoginEntity;

public interface ILoginJpaMapper {
	
	Login toDomain(LoginEntity entity);
	LoginEntity toEntity(Login loginPojo);

}
