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
@Table(name = "equipos_utilizados_ir")
public class EquiposUtilizadosIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipos;

	@Column(length = 120)
	private String nombre;

	@Column(length = 80)
	private String marca;

	@Column(length = 80)
	private String modelo;

	@Column(length = 80)
	private String serie;

	@Column(length = 60)
	private String codigoInterno;

	@ManyToOne
	@JoinColumn(name = "fk_informe")
	private InformeResultadosIREntity fkInformeEntity;

}
