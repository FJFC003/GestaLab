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
@Table(name = "Condiciones Ambientaes")
public class CondicionAmbientalIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCondi;
	@Column(length = 80)
	private String noAlicuota;
	private String horaToma;
	private String temperatura;
	private String humedad;
	private String precipitacion;

}
