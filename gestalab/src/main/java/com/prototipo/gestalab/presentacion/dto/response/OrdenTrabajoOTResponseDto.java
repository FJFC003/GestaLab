package com.prototipo.gestalab.presentacion.dto.response;

import java.util.Date;

public class OrdenTrabajoOTResponseDto {
	
	private int idOT;
	private int noItemOT;
	private Date fechaEmisionOT;
	private String nombrePersonaContactoOT;
	private Date fechaCierreCampoOT;
	private EmpleadoResponseDto fkResponsableEmision;
	private EmpleadoResponseDto fkTecnicoAsignado;
	private PlanMuestreoPLResponseDto fkPlanMuestreo;
	
	public EmpleadoResponseDto getFkResponsableEmision() {
		return fkResponsableEmision;
	}
	public void setFkResponsableEmision(EmpleadoResponseDto fkResponsableEmision) {
		this.fkResponsableEmision = fkResponsableEmision;
	}
	public EmpleadoResponseDto getFkTecnicoAsignado() {
		return fkTecnicoAsignado;
	}
	public void setFkTecnicoAsignado(EmpleadoResponseDto fkTecnicoAsignado) {
		this.fkTecnicoAsignado = fkTecnicoAsignado;
	}
	public PlanMuestreoPLResponseDto getFkPlanMuestreo() {
		return fkPlanMuestreo;
	}
	public void setFkPlanMuestreo(PlanMuestreoPLResponseDto fkPlanMuestreo) {
		this.fkPlanMuestreo = fkPlanMuestreo;
	}
	public int getIdOT() {
		return idOT;
	}
	public void setIdOT(int idOT) {
		this.idOT = idOT;
	}
	public int getNoItemOT() {
		return noItemOT;
	}
	public void setNoItemOT(int noItemOT) {
		this.noItemOT = noItemOT;
	}
	public Date getFechaEmisionOT() {
		return fechaEmisionOT;
	}
	public void setFechaEmisionOT(Date fechaEmisionOT) {
		this.fechaEmisionOT = fechaEmisionOT;
	}
	
	public String getNombrePersonaContactoOT() {
		return nombrePersonaContactoOT;
	}
	public void setNombrePersonaContactoOT(String nombrePersonaContactoOT) {
		this.nombrePersonaContactoOT = nombrePersonaContactoOT;
	}
	public Date getFechaCierreCampoOT() {
		return fechaCierreCampoOT;
	}
	public void setFechaCierreCampoOT(Date fechaCierreCampoOT) {
		this.fechaCierreCampoOT = fechaCierreCampoOT;
	}
	
	

}
