package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prototipo.gestalab.dominio.entidades.EstadoPlanMuestreo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

	@Column(length = 40)
	private String codigoPlan;

	@Column(length = 500)
	private String ObjetivoPlan;

	private Date fechaElaboracion;

	@Enumerated(EnumType.STRING)
	private EstadoPlanMuestreo estadoPlan;

	private Date fechaEnvioTecnico;

	@ManyToOne
	@JoinColumn(name = "fk_responsable")
	private EmpleadoEntity fkResponsableEntity;

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InformacionMatrizPLEntity> listaMatrices = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ParametroAnalizarPLEntity> listaParametros = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TipoTomaFreHoraPLEntity> listaTiposToma = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProcedimientoMuePLEntity> listaProcedimientos = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RecursosCronoPLEntity> listaRecursos = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InformacionAdicionalPLEntity> listaInfoAdicional = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VerificacionPLEntity> listaVerificaciones = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "fk_seguridad")
	private EEPPLEntity fkeep;

	@ManyToOne
	@JoinColumn(name = "fk_detalle_cotizacion")
	private DetalleCEntity fkDetalleCEntity;

	@OneToMany(mappedBy = "fkPlanMuestreoEntity")
	private List<OrdenTrabajoOTEntity> listaOrdenes = new ArrayList<>();
	
}
