package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "UsuarioHasRol")
public class UsuariohasRolEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuarioRol;
	private Date fechaAsignacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_Usuario")
	private UsuarioEntity fkUsuarioEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_Rol")
	private RolEntity fkRolEntity;

}
