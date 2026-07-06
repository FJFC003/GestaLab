package com.prototipo.gestalab.presentacion.dto.response;

public class ClienteCResponseDto {
	
	private int idClienteC;
	private String tipoClienteC;
	private String ciClienteC;
	private String nombreRazonSocialClienteC; //persona juridica (nombre de la empresa), persona natural (nombre completo)
	private String nombrePersonaContactoClienteC;
	private String direccionClienteC;
	private String telefonoClienteC;
	private String correoClienteC;
	private boolean estadoClienteC;
	public int getIdClienteC() {
		return idClienteC;
	}
	public void setIdClienteC(int idClienteC) {
		this.idClienteC = idClienteC;
	}
	public String getTipoClienteC() {
		return tipoClienteC;
	}
	public void setTipoClienteC(String tipoClienteC) {
		this.tipoClienteC = tipoClienteC;
	}
	public String getCiClienteC() {
		return ciClienteC;
	}
	public void setCiClienteC(String ciClienteC) {
		this.ciClienteC = ciClienteC;
	}
	public String getNombreRazonSocialClienteC() {
		return nombreRazonSocialClienteC;
	}
	public void setNombreRazonSocialClienteC(String nombreRazonSocialClienteC) {
		this.nombreRazonSocialClienteC = nombreRazonSocialClienteC;
	}
	public String getNombrePersonaContactoClienteC() {
		return nombrePersonaContactoClienteC;
	}
	public void setNombrePersonaContactoClienteC(String nombrePersonaContactoClienteC) {
		this.nombrePersonaContactoClienteC = nombrePersonaContactoClienteC;
	}
	public String getDireccionClienteC() {
		return direccionClienteC;
	}
	public void setDireccionClienteC(String direccionClienteC) {
		this.direccionClienteC = direccionClienteC;
	}
	public String getTelefonoClienteC() {
		return telefonoClienteC;
	}
	public void setTelefonoClienteC(String telefonoClienteC) {
		this.telefonoClienteC = telefonoClienteC;
	}
	public String getCorreoClienteC() {
		return correoClienteC;
	}
	public void setCorreoClienteC(String correoClienteC) {
		this.correoClienteC = correoClienteC;
	}
	public boolean isEstadoClienteC() {
		return estadoClienteC;
	}
	public void setEstadoClienteC(boolean estadoClienteC) {
		this.estadoClienteC = estadoClienteC;
	}

}
