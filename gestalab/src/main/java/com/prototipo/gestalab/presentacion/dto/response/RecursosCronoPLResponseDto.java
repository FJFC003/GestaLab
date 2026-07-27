package com.prototipo.gestalab.presentacion.dto.response;

import java.util.Date;

public class RecursosCronoPLResponseDto {
	
	private int idRecursos;
	private Date fechaMuestreo;
	private EmpleadoResponseDto fkTecnico;
	
	private PlanMuestreoPLResponseDto fkPlanMuestreo;

	public PlanMuestreoPLResponseDto getFkPlanMuestreo() {
		return fkPlanMuestreo;
	}

	public void setFkPlanMuestreo(PlanMuestreoPLResponseDto fkPlanMuestreo) {
		this.fkPlanMuestreo = fkPlanMuestreo;
	}
	
	public EmpleadoResponseDto getFkTecnico() {
		return fkTecnico;
	}
	public void setFkTecnico(EmpleadoResponseDto fkTecnico) {
		this.fkTecnico = fkTecnico;
	}
	private String recurso;
	private Date horaDefinida;
	public int getIdRecursos() {
		return idRecursos;
	}
	public void setIdRecursos(int idRecursos) {
		this.idRecursos = idRecursos;
	}
	public Date getFechaMuestreo() {
		return fechaMuestreo;
	}
	public void setFechaMuestreo(Date fechaMuestreo) {
		this.fechaMuestreo = fechaMuestreo;
	}
	
	public String getRecurso() {
		return recurso;
	}
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
	public Date getHoraDefinida() {
		return horaDefinida;
	}
	public void setHoraDefinida(Date horaDefinida) {
		this.horaDefinida = horaDefinida;
	}
	

}
