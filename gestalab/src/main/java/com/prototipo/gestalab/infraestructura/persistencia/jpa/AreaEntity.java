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
@Table(name = "Area")

public class AreaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idArea;
	@Column(length = 80)
	private String nombre;
	private String descripcion;
	private boolean estadoArea;
	
	@OneToMany(mappedBy = "fkAreaEntity")
	private List<EmpleadoEntity> listarEmpleado = new ArrayList<>();
	

}
