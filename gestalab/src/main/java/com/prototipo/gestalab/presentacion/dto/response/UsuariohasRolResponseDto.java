package com.prototipo.gestalab.presentacion.dto.response;

import java.util.Date;

public class UsuariohasRolResponseDto {
	
	private int idUsuarioRol;
	private Date fechaAsignacion;
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

}
