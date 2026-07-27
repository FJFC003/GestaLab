package com.prototipo.gestalab.presentacion.dto.response;

public class TipoTomaFreHoraPLResponseDto {
	
	private int idTipoFre;
	private int noItem;
	private String tipo;
	private String alicuotas;
	
	private PlanMuestreoPLResponseDto fkPlanMuestreo;

	public PlanMuestreoPLResponseDto getFkPlanMuestreo() {
		return fkPlanMuestreo;
	}

	public void setFkPlanMuestreo(PlanMuestreoPLResponseDto fkPlanMuestreo) {
		this.fkPlanMuestreo = fkPlanMuestreo;
	}
	
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
	
	

}
