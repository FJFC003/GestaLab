package com.prototipo.gestalab.presentacion.dto.response;

public class DatosLaboratorioIRResponseDto {
	
	private int idDatos;
	private String organizacion;
	private String direccion;
	private String telefono;
	private String correo;
	public int getIdDatos() {
		return idDatos;
	}
	public void setIdDatos(int idDatos) {
		this.idDatos = idDatos;
	}
	public String getOrganizacion() {
		return organizacion;
	}
	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
