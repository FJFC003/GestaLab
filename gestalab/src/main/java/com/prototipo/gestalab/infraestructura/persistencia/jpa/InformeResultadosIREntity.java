package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
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
