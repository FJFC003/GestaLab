package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
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
@Table(name = "Plan de Muestreo")
public class PlanMuestreoPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlan;
	@Column(length = 80)
	private String ObjetivoPlan;
	
	@ManyToOne
	@JoinColumn(name = "fk_info_adicional")
	private InformacionAdicionalPLEntity fkInfoAdicionalEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_info_matriz")
	private InformacionMatrizPLEntity fkinfomatriz;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_toma")
	private TipoTomaFreHoraPLEntity fktipotoma;
	
	@ManyToOne
	@JoinColumn(name = "fk_para_analizar")
	private ParametroAnalizarPLEntity fkparametro;
	
	@ManyToOne
	@JoinColumn(name = "fk_proc_muestreo")
	private ProcedimientoMuePLEntity fkprocedimiento;

	@ManyToOne
	@JoinColumn(name = "fk_rec_crono")
	private RecursosCronoPLEntity fkrecursos;
	
	@ManyToOne
	@JoinColumn(name = "fk_seguridad")
	private EEPPLEntity fkeep;
	
	@ManyToOne
	@JoinColumn(name = "fk_verificacion")
	private VerificacionPLEntity fkverificacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_detalle_cotizacion")
	private DetalleCEntity fkDetalleCEntity;
	
	@OneToMany(mappedBy = "fkPlanMuestreoEntity")
    private List<OrdenTrabajoOTEntity> listaOrdenes = new ArrayList<>();
	
}
