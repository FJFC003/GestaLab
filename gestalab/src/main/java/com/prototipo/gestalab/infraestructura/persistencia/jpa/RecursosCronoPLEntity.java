package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.Date;

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
@Table(name = "Recursos y cronograma")
public class RecursosCronoPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecursos;
	private Date fechaMuestreo;
	private String recurso;
	private Date horaDefinida;
	
	@ManyToOne
	@JoinColumn(name = "fk_tecnico")
	private EmpleadoEntity fkTecnicoEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_plan_muestreo")
	private PlanMuestreoPLEntity fkPlanMuestreoEntity;

}
