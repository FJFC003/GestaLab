package com.prototipo.gestalab.dominio.entidades;

public class TipoTomaFreHoraPL {
	
	private int idTipoFre;
	private int noItem;
	private String frecuencia;
	private String tipo;
	private String alicuotas;
	private PlanMuestreoPL fkPlanMuestreo;

	public int getIdTipoFre() {
		return idTipoFre;
	}
	public void setIdTipoFre(int idTipoFre) {
		this.idTipoFre = idTipoFre;
	}
	public int getNoItem() {
		return noItem;
	}
	public void setNoItem(int noItem) {
		this.noItem = noItem;
	}
	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAlicuotas() {
		return alicuotas;
	}
	public void setAlicuotas(String alicuotas) {
		this.alicuotas = alicuotas;
	}
	public PlanMuestreoPL getFkPlanMuestreo() {
		return fkPlanMuestreo;
	}
	public void setFkPlanMuestreo(PlanMuestreoPL fkPlanMuestreo) {
		this.fkPlanMuestreo = fkPlanMuestreo;
	}

}
