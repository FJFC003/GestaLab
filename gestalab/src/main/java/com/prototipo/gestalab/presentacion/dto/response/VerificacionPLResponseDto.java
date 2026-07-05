package com.prototipo.gestalab.presentacion.dto.response;

public class VerificacionPLResponseDto {
	
	private int idVerificacion;
	private int noItem;
	private boolean tipoMatrizDeclarada;
	private boolean frecuanciaDeclarada;
	private boolean sitiosDeclarados;
	public int getIdVerificacion() {
		return idVerificacion;
	}
	public void setIdVerificacion(int idVerificacion) {
		this.idVerificacion = idVerificacion;
	}
	public int getNoItem() {
		return noItem;
	}
	public void setNoItem(int noItem) {
		this.noItem = noItem;
	}
	public boolean isTipoMatrizDeclarada() {
		return tipoMatrizDeclarada;
	}
	public void setTipoMatrizDeclarada(boolean tipoMatrizDeclarada) {
		this.tipoMatrizDeclarada = tipoMatrizDeclarada;
	}
	public boolean isFrecuanciaDeclarada() {
		return frecuanciaDeclarada;
	}
	public void setFrecuanciaDeclarada(boolean frecuanciaDeclarada) {
		this.frecuanciaDeclarada = frecuanciaDeclarada;
	}
	public boolean isSitiosDeclarados() {
		return sitiosDeclarados;
	}
	public void setSitiosDeclarados(boolean sitiosDeclarados) {
		this.sitiosDeclarados = sitiosDeclarados;
	}
	
	

}
