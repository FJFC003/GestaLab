package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TipoTomaMuestra")
public class TipoTomaMuestraCEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoTomaMuestraC;
	private String codigoTipoTomaMuestraC;
	private String textoTipoTomaMuestraC;

	@Column(length = 500)
	private String observacionTipoTomaMuestraC;

	@OneToMany(mappedBy = "fkTipoTomaMuestraEntity")
	private List<DetalleCEntity> listaDetalles = new ArrayList<>();

}
