package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;


public class FirmaElectronica {
	
	private int idFirma;
	private String formatoFirma;
	private Date fechaSubida;
	private Date fechaExpiracion;
	
	public int getIdFirma() {
		return idFirma;
	}
	public void setIdFirma(int idFirma) {
		this.idFirma = idFirma;
	}
	public String getFormatoFirma() {
		return formatoFirma;
	}
	public void setFormatoFirma(String formatoFirma) {
		this.formatoFirma = formatoFirma;
	}
	public Date getFechaSubida() {
		return fechaSubida;
	}
	public void setFechaSubida(Date fechaSubida) {
		this.fechaSubida = fechaSubida;
	}
	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	
	

}
