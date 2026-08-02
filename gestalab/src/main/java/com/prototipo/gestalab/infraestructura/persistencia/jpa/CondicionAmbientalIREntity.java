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
@Table(name = "condicion_ambiental_ir")
public class CondicionAmbientalIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCondi;

	@Column(length = 40)
	private String noAlicuota;

	@Column(length = 20)
	private String horaToma;

	@Column(length = 40)
	private String temperatura;

	@Column(length = 40)
	private String humedad;

	@Column(length = 60)
	private String precipitacion;

	@ManyToOne
	@JoinColumn(name = "fk_informe")
	private InformeResultadosIREntity fkInformeEntity;

}
