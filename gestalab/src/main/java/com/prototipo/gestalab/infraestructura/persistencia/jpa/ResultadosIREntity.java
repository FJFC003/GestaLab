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

@Entity
@Data
@Table(name = "Resultados")
public class ResultadosIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResultados;
	@Column(length = 80)
	private String parametros;
	private String metodoReferencial;
	private String unidad;
	private String resultado;
	private String incertidumbre;
	private String LMP;
	private String conformidad;
	
	@OneToMany(mappedBy = "fkResultadosEntity")
	private List<InformeResultadosIREntity> listarInforme = new ArrayList<>();

}
