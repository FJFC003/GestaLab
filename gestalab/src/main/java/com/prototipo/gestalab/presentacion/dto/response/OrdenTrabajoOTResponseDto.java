package com.prototipo.gestalab.presentacion.dto.response;

import java.util.Date;

public class OrdenTrabajoOTResponseDto {
	
	private int idOT;
	private int noItemOT;
	private Date fechaEmisionOT;
	private String responsableEmsionOT;
	private String tecnicoLaboratorioOT;
	private String nombrePersonaContactoOT;
	private Date fechaCierreCampoOT;
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
	public String getResponsableEmsionOT() {
		return responsableEmsionOT;
	}
	public void setResponsableEmsionOT(String responsableEmsionOT) {
		this.responsableEmsionOT = responsableEmsionOT;
	}
	public String getTecnicoLaboratorioOT() {
		return tecnicoLaboratorioOT;
	}
	public void setTecnicoLaboratorioOT(String tecnicoLaboratorioOT) {
		this.tecnicoLaboratorioOT = tecnicoLaboratorioOT;
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
