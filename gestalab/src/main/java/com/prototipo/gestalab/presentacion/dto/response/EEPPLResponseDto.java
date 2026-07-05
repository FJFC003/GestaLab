package com.prototipo.gestalab.presentacion.dto.response;

public class EEPPLResponseDto {
	
	private int idEEP;
	private boolean chaleco;
	private boolean gafas;
	private boolean casco;
	private boolean mandil;
	private boolean mascarilla;
	private boolean botas;
	private boolean zapatos;
	private boolean accesoProPrivada;
	
	public int getIdEEP() {
		return idEEP;
	}
	public void setIdEEP(int idEEP) {
		this.idEEP = idEEP;
	}
	public boolean isChaleco() {
		return chaleco;
	}
	public void setChaleco(boolean chaleco) {
		this.chaleco = chaleco;
	}
	public boolean isGafas() {
		return gafas;
	}
	public void setGafas(boolean gafas) {
		this.gafas = gafas;
	}
	public boolean isCasco() {
		return casco;
	}
	public void setCasco(boolean casco) {
		this.casco = casco;
	}
	public boolean isMandil() {
		return mandil;
	}
	public void setMandil(boolean mandil) {
		this.mandil = mandil;
	}
	public boolean isMascarilla() {
		return mascarilla;
	}
	public void setMascarilla(boolean mascarilla) {
		this.mascarilla = mascarilla;
	}
	public boolean isBotas() {
		return botas;
	}
	public void setBotas(boolean botas) {
		this.botas = botas;
	}
	public boolean isZapatos() {
		return zapatos;
	}
	public void setZapatos(boolean zapatos) {
		this.zapatos = zapatos;
	}
	public boolean isAccesoProPrivada() {
		return accesoProPrivada;
	}
	public void setAccesoProPrivada(boolean accesoProPrivada) {
		this.accesoProPrivada = accesoProPrivada;
	}
}
