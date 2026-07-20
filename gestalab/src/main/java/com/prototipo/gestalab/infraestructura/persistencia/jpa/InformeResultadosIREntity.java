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
@Table(name = "Informe de Resultados")
public class InformeResultadosIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInforme;
	@Column(length = 80)
	private String notasAdvertencia;
	private String nombreResponsable;
	
	@ManyToOne
	@JoinColumn(name = "fk_Datos_laboratorio")
	private DatosLaboratorioIREntity fkDatosLaboratorioEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_condicion_ambiental")
	private CondicionAmbientalIREntity fkCondicionesAmbientalesEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_equipos_utilizados")
	private EquiposUtilizadosIREntity fkEquiposUtilizadosEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_resultados")
	private ResultadosIREntity fkResultadosEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_orden_trabajo")
	private OrdenTrabajoOTEntity fkOrdenTrabajoEntity;

}
