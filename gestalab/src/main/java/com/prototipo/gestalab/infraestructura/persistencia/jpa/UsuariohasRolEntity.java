package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "UsuarioHasRol")
public class UsuariohasRolEntity {
	
	private Date fechaAsignacion;

}
