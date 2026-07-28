package com.prototipo.gestalab.dominio.entidades;


public class DesviosOrdenOT {
	
	private int idDesviosOrdenOT;
	private int noItemDesviosOrdenOT;
	private String descripcionDesviosOrdenOT;
	private int puntosModificadosDesviosOrdenOT;
	private OrdenTrabajoOT fkOrdenTrabajo;
	public int getIdDesviosOrdenOT() {
		return idDesviosOrdenOT;
	}
	public void setIdDesviosOrdenOT(int idDesviosOrdenOT) {
		this.idDesviosOrdenOT = idDesviosOrdenOT;
	}
	public int getNoItemDesviosOrdenOT() {
		return noItemDesviosOrdenOT;
	}
	public void setNoItemDesviosOrdenOT(int noItemDesviosOrdenOT) {
		this.noItemDesviosOrdenOT = noItemDesviosOrdenOT;
	}
	public String getDescripcionDesviosOrdenOT() {
		return descripcionDesviosOrdenOT;
	}
	public void setDescripcionDesviosOrdenOT(String descripcionDesviosOrdenOT) {
		this.descripcionDesviosOrdenOT = descripcionDesviosOrdenOT;
	}
	public int getPuntosModificadosDesviosOrdenOT() {
		return puntosModificadosDesviosOrdenOT;
	}
	public void setPuntosModificadosDesviosOrdenOT(int puntosModificadosDesviosOrdenOT) {
		this.puntosModificadosDesviosOrdenOT = puntosModificadosDesviosOrdenOT;
	}
	public OrdenTrabajoOT getFkOrdenTrabajo() {
		return fkOrdenTrabajo;
	}
	public void setFkOrdenTrabajo(OrdenTrabajoOT fkOrdenTrabajo) {
		this.fkOrdenTrabajo = fkOrdenTrabajo;
	}
	

}
