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
	
	@OneToMany(mappedBy = "fkverificacion")
	private List<PlanMuestreoPLEntity> listarverificaciones= new ArrayList<>();

}
