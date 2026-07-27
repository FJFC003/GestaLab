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
@Table(name = "Parametros a Analizar")
public class ParametroAnalizarPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParametroPL;
	private int noParametroPL;
	private String Parametros;
	
	@ManyToOne
	@JoinColumn(name = "fk_plan_muestreo")
	private PlanMuestreoPLEntity fkPlanMuestreoEntity;


}
