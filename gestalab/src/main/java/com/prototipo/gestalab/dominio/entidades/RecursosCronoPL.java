package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;

public class RecursosCronoPL {
	
	private int idRecursos;
	private Date fechaMuestreo;
	private String recurso;
	private Date horaDefinida;
	private Empleado fkTecnico;
	
	public Empleado getFkTecnico() {
		return fkTecnico;
	}
	public void setFkTecnico(Empleado fkTecnico) {
		this.fkTecnico = fkTecnico;
	}
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
