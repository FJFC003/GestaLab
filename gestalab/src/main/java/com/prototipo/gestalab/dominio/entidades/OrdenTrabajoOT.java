package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;


public class OrdenTrabajoOT {
	
	private int idOT;
	private int noItemOT;
	private Date fechaEmisionOT;
	private String nombrePersonaContactoOT;
	private Date fechaCierreCampoOT;
	private Empleado fkResponsableEmision;
	private Empleado fkTecnicoAsignado;
	private PlanMuestreoPL fkPlanMuestreo;
	
	public Empleado getFkResponsableEmision() {
		return fkResponsableEmision;
	}
	public void setFkResponsableEmision(Empleado fkResponsableEmision) {
		this.fkResponsableEmision = fkResponsableEmision;
	}
	public Empleado getFkTecnicoAsignado() {
		return fkTecnicoAsignado;
	}
	public void setFkTecnicoAsignado(Empleado fkTecnicoAsignado) {
		this.fkTecnicoAsignado = fkTecnicoAsignado;
	}
	public PlanMuestreoPL getFkPlanMuestreo() {
		return fkPlanMuestreo;
	}
	public void setFkPlanMuestreo(PlanMuestreoPL fkPlanMuestreo) {
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
