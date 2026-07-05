package com.prototipo.gestalab.presentacion.dto.response;

public class InformacionMatrizPLResponseDto {
	
	private int idInfoMatriz;
	private int noItem;
	private String tipoMatriz;
	private String Ubicacion;
	private String descripcionDelPunto;
	private String Accesibilidad;
	
	public int getIdInfoMatriz() {
		return idInfoMatriz;
	}
	public void setIdInfoMatriz(int idInfoMatriz) {
		this.idInfoMatriz = idInfoMatriz;
	}
	public int getNoItem() {
		return noItem;
	}
	public void setNoItem(int noItem) {
		this.noItem = noItem;
	}
	public String getTipoMatriz() {
		return tipoMatriz;
	}
	public void setTipoMatriz(String tipoMatriz) {
		this.tipoMatriz = tipoMatriz;
	}
	public String getUbicacion() {
		return Ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		Ubicacion = ubicacion;
	}
	public String getDescripcionDelPunto() {
		return descripcionDelPunto;
	}
	public void setDescripcionDelPunto(String descripcionDelPunto) {
		this.descripcionDelPunto = descripcionDelPunto;
	}
	public String getAccesibilidad() {
		return Accesibilidad;
	}
	public void setAccesibilidad(String accesibilidad) {
		Accesibilidad = accesibilidad;
	}
	
	

}
