package com.prototipo.gestalab.infraestructura.persistencia.jpa;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Informacion de la Matriz")
public class InformacionMatrizPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInfoMatriz;
	private int noItem;
	private String tipoMatriz;
	private String Ubicacion;
	private String descripcionDelPunto;
	private String Accesibilidad;

	@ManyToOne
	@JoinColumn(name = "fk_plan_muestreo")
	private PlanMuestreoPLEntity fkPlanMuestreoEntity;

}
