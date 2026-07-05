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
@Table(name = "EEP")
public class EEPPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEEP;
	@Column(length = 80)
	private boolean chaleco;
	private boolean gafas;
	private boolean casco;
	private boolean mandil;
	private boolean mascarilla;
	private boolean botas;
	private boolean zapatos;
	private boolean accesoProPrivada;

}
