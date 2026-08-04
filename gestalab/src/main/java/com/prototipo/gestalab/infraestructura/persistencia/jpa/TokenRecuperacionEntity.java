package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "token_recuperacion")
public class TokenRecuperacionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idToken;

	/**
	 * Huella SHA-256 del token en hexadecimal: siempre 64 caracteres.
	 * Es unica e indexada, asi que resolver un enlace es una sola consulta.
	 */
	@Column(name = "hash_token", length = 64, nullable = false, unique = true)
	private String hashToken;

	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	private UsuarioEntity fkUsuarioEntity;

	private Date fechaCreacion;

	private Date fechaExpiracion;

	private boolean usado;

}