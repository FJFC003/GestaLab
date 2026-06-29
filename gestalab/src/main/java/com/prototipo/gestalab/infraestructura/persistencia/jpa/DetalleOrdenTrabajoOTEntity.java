package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Monitoreos y monitoreo planificados y estipulados en el contrato")
public class DetalleOrdenTrabajoOTEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleOrdenOT;
	@Column(length = 80)
	private Date fechaPlanificadaDetalleOrdenOT;
	private int puntosPlanificadosDetalleOrdenOT;
	private int puntosEjecutadosDetalleOrdenOT;

}
