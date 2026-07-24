package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Login")
@Entity
public class LoginEntity {
	
	@Column(length = 80)
	private String correo;
	private String contrasenia;

}
