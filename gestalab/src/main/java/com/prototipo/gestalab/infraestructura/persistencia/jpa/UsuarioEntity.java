package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "Usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	@Column(length = 80)
	private String nombre;
	private String correo;
	private String contrasenia;
	private Date fechaCreacion;
	private boolean estadoUsuario;
	
	@OneToMany(mappedBy = "fkUsuarioEntity")
	private List<EmpleadoEntity> listarEmpleado = new ArrayList<>();
	
	@OneToMany(mappedBy = "fkUsuarioEntity")
	private List<UsuariohasRolEntity> listarUsuariohasRol = new ArrayList<>();

}
