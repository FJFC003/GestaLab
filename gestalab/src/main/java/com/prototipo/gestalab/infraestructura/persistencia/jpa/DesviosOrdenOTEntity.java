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
@Table(name = "desvios_orden_trabajo")
public class DesviosOrdenOTEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDesviosOrdenOT;

	private int noItemDesviosOrdenOT;

	@Column(length = 600)
	private String descripcionDesviosOrdenOT;

	private int puntosModificadosDesviosOrdenOT;

	@ManyToOne
	@JoinColumn(name = "fk_orden_trabajo")
	private OrdenTrabajoOTEntity fkOrdenTrabajoEntity;

}
