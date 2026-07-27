package com.prototipo.gestalab.presentacion.dto.response;

public class InformacionAdicionalPLResponseDto {
	
	private int idInformacion;
	private String preguntas;
	private String respuesta;
	
	private PlanMuestreoPLResponseDto fkPlanMuestreo;

	public PlanMuestreoPLResponseDto getFkPlanMuestreo() {
		return fkPlanMuestreo;
	}

	public void setFkPlanMuestreo(PlanMuestreoPLResponseDto fkPlanMuestreo) {
		this.fkPlanMuestreo = fkPlanMuestreo;
	}
	
	public int getIdInformacion() {
		return idInformacion;
	}
	public void setIdInformacion(int idInformacion) {
		this.idInformacion = idInformacion;
	}
	public String getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(String preguntas) {
		this.preguntas = preguntas;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	

}
