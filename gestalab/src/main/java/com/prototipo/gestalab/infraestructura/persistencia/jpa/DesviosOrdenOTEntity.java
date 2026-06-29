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
@Table(name = "Desvios IN SITU")
public class DesviosOrdenOTEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDesviosOrdenOT;
	@Column(length = 80)
	private String descripcionDesviosOrdenOT;
	private int puntosModificadosDesviosOrdenOT;

}
