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
@Table(name = "Monitoreos y monitoreo planificados y estipulados en el contrato")
public class DetalleOrdenTrabajoOTEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleOrdenOT;
	@Column(length = 80)
	private Date fechaPlanificadaDetalleOrdenOT;
	private int puntosPlanificadosDetalleOrdenOT;
	private int puntosEjecutadosDetalleOrdenOT;
	
	@OneToMany(mappedBy = "fkMonitoreos")
    private List<OrdenTrabajoOTEntity> listaOrdenesTrabajo = new ArrayList<>();

}
