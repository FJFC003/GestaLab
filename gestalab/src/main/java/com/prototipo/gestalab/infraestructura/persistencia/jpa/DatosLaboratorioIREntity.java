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
@Table(name = "Datos del Labboratorio")
public class DatosLaboratorioIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDatos;
	@Column(length = 80)
	private String organizacion;
	private String direccion;
	private String telefono;
	private String correo;
	
	@OneToMany(mappedBy = "fkDatosLaboratorioEntity")
	private List<InformeResultadosIREntity> listarInforme = new ArrayList<>();

}
