package com.prototipo.gestalab.presentacion.dto.response;

public class ParametroAnalizarPLResponseDto {
	
	private int idParametroPL;
	private int noParametroPL;
	private String Parametros;
	private String unidadMedida;
	private String sitioMedicion;
	private String preservacion;
	private PlanMuestreoPLResponseDto fkPlanMuestreo;

	public int getIdParametroPL() {
		return idParametroPL;
	}
	public void setIdParametroPL(int idParametroPL) {
		this.idParametroPL = idParametroPL;
	}
	public int getNoParametroPL() {
		return noParametroPL;
	}
	public void setNoParametroPL(int noParametroPL) {
		this.noParametroPL = noParametroPL;
	}
	public String getParametros() {
		return Parametros;
	}
	public void setParametros(String parametros) {
		Parametros = parametros;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public String getSitioMedicion() {
		return sitioMedicion;
	}
	public void setSitioMedicion(String sitioMedicion) {
		this.sitioMedicion = sitioMedicion;
	}
	public String getPreservacion() {
		return preservacion;
	}
	public void setPreservacion(String preservacion) {
		this.preservacion = preservacion;
	}
	public PlanMuestreoPLResponseDto getFkPlanMuestreo() {
		return fkPlanMuestreo;
	}
	public void setFkPlanMuestreo(PlanMuestreoPLResponseDto fkPlanMuestreo) {
		this.fkPlanMuestreo = fkPlanMuestreo;
	}

}
