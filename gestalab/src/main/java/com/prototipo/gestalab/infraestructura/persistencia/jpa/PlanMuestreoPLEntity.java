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

	// IMPORTANTE: solo CascadeType.REMOVE, NUNCA orphanRemoval.
	//
	// REMOVE basta para que al borrar el plan se borren sus 7 secciones.
	//
	// orphanRemoval seria un error grave aqui: MapStruct construye la entidad
	// con estas listas VACIAS, asi que al actualizar el plan (por ejemplo al
	// guardar el EPP) Hibernate entenderia que hay que borrar todas las
	// secciones, y lanza:
	//   "A collection with cascade=all-delete-orphan was no longer referenced"

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.REMOVE)
	private List<InformacionMatrizPLEntity> listaMatrices = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.REMOVE)
	private List<ParametroAnalizarPLEntity> listaParametros = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.REMOVE)
	private List<TipoTomaFreHoraPLEntity> listaTiposToma = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.REMOVE)
	private List<ProcedimientoMuePLEntity> listaProcedimientos = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.REMOVE)
	private List<RecursosCronoPLEntity> listaRecursos = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.REMOVE)
	private List<InformacionAdicionalPLEntity> listaInfoAdicional = new ArrayList<>();

	@OneToMany(mappedBy = "fkPlanMuestreoEntity", cascade = CascadeType.REMOVE)
	private List<VerificacionPLEntity> listaVerificaciones = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "fk_seguridad")
	private EEPPLEntity fkeep;

	@ManyToOne
	@JoinColumn(name = "fk_detalle_cotizacion")
	private DetalleCEntity fkDetalleCEntity;

	// Las Ordenes de Trabajo NO se borran en cascada: son documentos con valor
	// propio. Si el plan tiene OT, hay que eliminarlas primero.
	@OneToMany(mappedBy = "fkPlanMuestreoEntity")
	private List<OrdenTrabajoOTEntity> listaOrdenes = new ArrayList<>();
	
}
