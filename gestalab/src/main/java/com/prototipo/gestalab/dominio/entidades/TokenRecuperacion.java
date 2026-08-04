package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;

public class TokenRecuperacion {
	
	private int idToken;
	private String hashToken;
	private Usuario fkUsuario;
	private Date fechaCreacion;
	private Date fechaExpiracion;
	private boolean usado;

	public int getIdToken() {
		return idToken;
	}
	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}
	public String getHashToken() {
		return hashToken;
	}
	public void setHashToken(String hashToken) {
		this.hashToken = hashToken;
	}
	public Usuario getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(Usuario fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public boolean isUsado() {
		return usado;
	}
	public void setUsado(boolean usado) {
		this.usado = usado;
	}

}
