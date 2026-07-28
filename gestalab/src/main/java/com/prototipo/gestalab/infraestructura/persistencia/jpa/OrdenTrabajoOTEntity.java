package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajoOTEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOT;

	private int noItemOT;
	private Date fechaEmisionOT;
	private String nombrePersonaContactoOT;
	private Date fechaCierreCampoOT;

	// Las lineas son PARTE de la orden: se borran con ella
	@OneToMany(mappedBy = "fkOrdenTrabajoEntity", cascade = CascadeType.REMOVE)
	private List<DetalleOrdenTrabajoOTEntity> listaMonitoreos = new ArrayList<>();

	@OneToMany(mappedBy = "fkOrdenTrabajoEntity", cascade = CascadeType.REMOVE)
	private List<DesviosOrdenOTEntity> listaDesvios = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "fk_plan_muestreo")
	private PlanMuestreoPLEntity fkPlanMuestreoEntity;

	@OneToMany(mappedBy = "fkOrdenTrabajoEntity")
	private List<InformeResultadosIREntity> listaInformen = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "fk_responsable_emision")
	private EmpleadoEntity fkResponsableEmisionEntity;

	@ManyToOne
	@JoinColumn(name = "fk_tecnico_asignado")
	private EmpleadoEntity fkTecnicoAsignadoEntity;

}
