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
@Table(name = "Informacion de la Matriz")
public class InformacionMatrizPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInfoMatriz;
	@Column(length = 80)
	private int noItem;
	private String tipoMatriz;
	private String Ubicacion;
	private String descripcionDelPunto;
	private String Accesibilidad;

}
