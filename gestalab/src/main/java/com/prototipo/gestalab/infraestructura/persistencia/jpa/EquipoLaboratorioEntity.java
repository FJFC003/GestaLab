package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "equipo_laboratorio")
public class EquipoLaboratorioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipoLab;

	@Column(length = 150)
	private String nombre;

	@Column(length = 80)
	private String marca;

	@Column(length = 80)
	private String modelo;

	@Column(length = 80)
	private String serie;

	@Column(length = 60)
	private String codigoInterno;

	// Permite retirar un equipo del catalogo sin borrarlo, para no perder
	// la trazabilidad de los informes que ya lo usaron.
	private boolean estadoEquipoLab = true;

}
