package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;

public class UsuariohasRol {
	
	private int idUsuarioRol;
	private Date fechaAsignacion;
	private Usuario fkUsuario;
	private Rol fkRol;
	
	public int getIdUsuarioRol() {
		return idUsuarioRol;
	}
	public void setIdUsuarioRol(int idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public Usuario getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(Usuario fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
	public Rol getFkRol() {
		return fkRol;
	}
	public void setFkRol(Rol fkRol) {
		this.fkRol = fkRol;
	}

}
