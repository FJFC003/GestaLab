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
@Table(name = "Verificacion")
public class VerificacionPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVerificacion;
	@Column(length = 80)
	private int noItem;
	private boolean tipoMatrizDeclarada;
	private boolean frecuanciaDeclarada;
	private boolean sitiosDeclarados;

}
