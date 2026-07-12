package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
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
@Table(name = "Orden de ejecucion del trabajo")
public class OrdenTrabajoOTEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOT;
	@Column(length = 80)
	private int noItemOT;
	private Date fechaEmisionOT;
	private String responsableEmsionOT;
	private String tecnicoLaboratorioOT;
	private String nombrePersonaContactoOT;
	private Date fechaCierreCampoOT;
	
	@ManyToOne
    @JoinColumn(name = "fk_Monitoreos")
    private DetalleOrdenTrabajoOTEntity fkMonitoreos;
	
	@ManyToOne
    @JoinColumn(name = "fk_Desvio")
    private DesviosOrdenOTEntity fkDesvio;
	
	@ManyToOne
    @JoinColumn(name = "fk_Detalle_Cotizacion")
    private DetalleCEntity fkDetalleCEntity;
	
	@OneToMany(mappedBy = "fkOrdenTrabajoEntity")
    private List<PlanMuestreoPLEntity> listaPlanes = new ArrayList<>();



}
