package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prototipo.gestalab.dominio.entidades.EstadoInformeIR;

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
@Table(name = "informe_resultados")
public class InformeResultadosIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInforme;

	@Column(length = 40)
	private String codigoInforme;

	private Date fechaEmisionInforme;

	@Column(length = 1000)
	private String notasAdvertencia;

	@Column(length = 120)
	private String nombreResponsable;

	@Column(length = 30)
	private String conformidadGeneral;

	// Estado del flujo hacia la Coordinacion Tecnica.
	@Enumerated(EnumType.STRING)
	private EstadoInformeIR estadoInforme = EstadoInformeIR.EN_ELABORACION;

	private Date fechaEnvioCoordinacion;

	// ---- Informacion del sitio de muestreo ----
	// Columnas nuevas: con ddl-auto=update Hibernate las crea al arrancar.
	@Column(length = 120)
	private String identificacionSitioMuestreo;

	@Column(length = 40)
	private String coordenadaUtmX;

	@Column(length = 40)
	private String coordenadaUtmY;

	@Column(length = 60)
	private String codigoCadenaCustodia;

	@Column(length = 60)
	private String codigoLaboratorio;

	@Column(length = 300)
	private String procedimientoTomaMuestra;

	private Date fechaIngresoLaboratorio;

	@Column(columnDefinition = "bytea")
	private byte[] imagenMapa;
	private String imagenMapaTipo;

	@Column(length = 1000)
	private String motivoDevolucion;
	private Date fechaDevolucionLaboratorio;

	@ManyToOne
	@JoinColumn(name = "fk_lmp")
	private LmpCEntity fkLmpEntity;

	@ManyToOne
	@JoinColumn(name = "fk_datos_laboratorio")
	private DatosLaboratorioIREntity fkDatosLaboratorioEntity;

	@ManyToOne
	@JoinColumn(name = "fk_orden_trabajo")
	private OrdenTrabajoOTEntity fkOrdenTrabajoEntity;

	@OneToMany(mappedBy = "fkInformeEntity", cascade = CascadeType.REMOVE)
	private List<ResultadosIREntity> listaResultados = new ArrayList<>();

	@OneToMany(mappedBy = "fkInformeEntity", cascade = CascadeType.REMOVE)
	private List<CondicionAmbientalIREntity> listaCondiciones = new ArrayList<>();

	@OneToMany(mappedBy = "fkInformeEntity", cascade = CascadeType.REMOVE)
	private List<EquiposUtilizadosIREntity> listaEquipos = new ArrayList<>();



}
