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
@Table(name = "datos_laboratorio_ir")
public class DatosLaboratorioIREntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDatos;

	@Column(length = 150)
	private String organizacion;

	@Column(length = 200)
	private String direccion;

	@Column(length = 40)
	private String telefono;

	@Column(length = 120)
	private String correo;

	@OneToMany(mappedBy = "fkDatosLaboratorioEntity")
	private List<InformeResultadosIREntity> listarInforme = new ArrayList<>();

}
