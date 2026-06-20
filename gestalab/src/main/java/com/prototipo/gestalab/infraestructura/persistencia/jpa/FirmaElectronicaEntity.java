package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "FirmaElectronica")

public class FirmaElectronicaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFirma;
	@Column(length = 80)
	private String formatoFirma;
	private Date fechaSubida;
	private Date fechaExpiracion;

}
