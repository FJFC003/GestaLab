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
@Table(name = "CatalogoPlanMuestreo")
public class CatalogoPlanPLEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCatalogoPlanPL;
	private String tipoLista;
	private String valorCatalogoPlanPL;

	@Column(length = 500)
	private String descripcionCatalogoPlanPL;
	private int ordenCatalogoPlanPL;
	private boolean estadoCatalogoPlanPL;

}
