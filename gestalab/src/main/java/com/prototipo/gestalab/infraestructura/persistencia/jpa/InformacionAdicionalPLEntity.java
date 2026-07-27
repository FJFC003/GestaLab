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
@Table(name = "Informacion Adicional")
public class InformacionAdicionalPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInformacion;
	private String preguntas;
	private String respuesta;
	
	@ManyToOne
	@JoinColumn(name = "fk_plan_muestreo")
	private PlanMuestreoPLEntity fkPlanMuestreoEntity;

}
