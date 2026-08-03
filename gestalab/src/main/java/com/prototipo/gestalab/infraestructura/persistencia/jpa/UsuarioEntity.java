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
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuario",uniqueConstraints = {@UniqueConstraint
		(name = "uk_usuario_correo", columnNames = { "correo" })})
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(length = 80, nullable = false)
	private String nombre;

	@Column(length = 120, nullable = false, unique = true)
	private String correo;

	@Column(length = 100, nullable = false)
	private String contrasenia;

	private Date fechaCreacion;

	private boolean estadoUsuario;

	/**
	 * Pregunta de seguridad para recuperar el acceso.
	 * Nullable a proposito: las cuentas ya existentes no la tienen configurada
	 * y deben poder seguir funcionando sin cambios.
	 */
	@Column(length = 150)
	private String preguntaSeguridad;

	/** Respuesta guardada como hash BCrypt (60 caracteres). */
	@Column(length = 100)
	private String respuestaSeguridad;

	@OneToMany(mappedBy = "fkUsuarioEntity")
	private List<EmpleadoEntity> listarEmpleado = new ArrayList<>();

	@OneToMany(mappedBy = "fkUsuarioEntity")
	private List<UsuariohasRolEntity> listarUsuariohasRol = new ArrayList<>();

}