package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Recursos y cronograma")
public class RecursosCronoPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecursos;
	@Column(length = 80)
	private Date fechaMuestreo;
	private String nombreTecnico;
	private String recurso;
	private Date horaDefinida;
	
	@OneToMany(mappedBy = "fkrecursos")
	private List<PlanMuestreoPLEntity> listarrecursos= new ArrayList<>();

}
