package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Cliente")
public class ClienteCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClienteC;
	@Column(length = 80)
	private String tipoClienteC;
	private String ciClienteC;
	private String nombreRazonSocialClienteC; //persona juridica (nombre de la empresa), persona natural (nombre completo)
	private String nombrePersonaContactoClienteC;
	private String direccionClienteC;
	private String telefonoClienteC;
	private String correoClienteC;
	private boolean estadoClienteC;

}
