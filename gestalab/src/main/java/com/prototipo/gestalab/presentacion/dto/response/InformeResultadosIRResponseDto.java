package com.prototipo.gestalab.presentacion.dto.response;

public class InformeResultadosIRResponseDto {
	
	private int idInforme;
	private String notasAdvertencia;
	private String nombreResponsable;
	public int getIdInforme() {
		return idInforme;
	}
	public void setIdInforme(int idInforme) {
		this.idInforme = idInforme;
	}
	public String getNotasAdvertencia() {
		return notasAdvertencia;
	}
	public void setNotasAdvertencia(String notasAdvertencia) {
		this.notasAdvertencia = notasAdvertencia;
	}
	public String getNombreResponsable() {
		return nombreResponsable;
	}
	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

}
