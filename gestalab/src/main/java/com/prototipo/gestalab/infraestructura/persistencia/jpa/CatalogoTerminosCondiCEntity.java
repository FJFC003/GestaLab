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
@Table(name = "Terminos y Condiciones")
public class CatalogoTerminosCondiCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTerminoC;
	@Column(length = 80)
	private String tituloTerminoC;
	private String contenidoTerminoC;

}
