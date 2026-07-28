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
@Table(name = "detalle_orden_trabajo")
public class DetalleOrdenTrabajoOTEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleOrdenOT;

	private int noItemDetalleOrdenOT;

	private String descripcionActividadDetalleOrdenOT;

	private Date fechaPlanificadaDetalleOrdenOT;

	private int puntosPlanificadosDetalleOrdenOT;

	// Lo escribe la Coordinacion Tecnica al cerrar la orden
	private int puntosEjecutadosDetalleOrdenOT;

	@ManyToOne
	@JoinColumn(name = "fk_orden_trabajo")
	private OrdenTrabajoOTEntity fkOrdenTrabajoEntity;

}