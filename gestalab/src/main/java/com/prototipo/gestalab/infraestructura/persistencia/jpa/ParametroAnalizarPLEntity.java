package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
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
@Table(name = "Parametros a Analizar")
public class ParametroAnalizarPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParametroPL;
	@Column(length = 80)
	private int noParametroPL;
	private String Parametros;
	
	@OneToMany(mappedBy = "fkparametro")
	private List<PlanMuestreoPLEntity> listarparametro= new ArrayList<>();

}
