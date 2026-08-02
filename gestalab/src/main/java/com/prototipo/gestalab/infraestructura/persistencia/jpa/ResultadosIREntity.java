package com.prototipo.gestalab.infraestructura.persistencia.jpa;


import jakarta.persistence.Column;
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
@Table(name = "resultados_ir")
public class ResultadosIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResultados;

	private int noItem;

	@Column(length = 150)
	private String parametros;

	@Column(length = 150)
	private String metodoReferencial;

	@Column(length = 40)
	private String unidad;

	@Column(length = 60)
	private String resultado;

	@Column(length = 60)
	private String incertidumbre;

	@Column(length = 60)
	private String LMP;

	@Column(length = 30)
	private String conformidad;

	@ManyToOne
	@JoinColumn(name = "fk_informe")
	private InformeResultadosIREntity fkInformeEntity;

}
