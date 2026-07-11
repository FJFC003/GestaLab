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
@Table(name = "Informacion Adicional")
public class InformacionAdicionalPLEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInformacion;
	@Column(length = 80)
	private String preguntas;
	private String respuesta;
	
	@OneToMany(mappedBy = "fkInfoAdicionalEntity")
	private List<PlanMuestreoPLEntity> listarinfo= new ArrayList<>();

}
