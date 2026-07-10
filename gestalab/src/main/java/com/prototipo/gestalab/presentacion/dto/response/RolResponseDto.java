package com.prototipo.gestalab.presentacion.dto.response;

public class RolResponseDto {
	
	private int idRol;
	private String nombre;
	private String descripcion;
	private boolean estadoRol;
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEstadoRol() {
		return estadoRol;
	}
	public void setEstadoRol(boolean estadoRol) {
		this.estadoRol = estadoRol;
	}

}
