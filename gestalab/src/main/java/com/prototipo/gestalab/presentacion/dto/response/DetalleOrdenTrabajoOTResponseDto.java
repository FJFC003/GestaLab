package com.prototipo.gestalab.presentacion.dto.response;

import java.util.Date;

public class DetalleOrdenTrabajoOTResponseDto {
	
	private int idDetalleOrdenOT;
	private int noItemDetalleOrdenOT;
	private String descripcionActividadDetalleOrdenOT;
	private Date fechaPlanificadaDetalleOrdenOT;
	private int puntosPlanificadosDetalleOrdenOT;
	private int puntosEjecutadosDetalleOrdenOT;
	public int getIdDetalleOrdenOT() {
		return idDetalleOrdenOT;
	}
	public void setIdDetalleOrdenOT(int idDetalleOrdenOT) {
		this.idDetalleOrdenOT = idDetalleOrdenOT;
	}
	public int getNoItemDetalleOrdenOT() {
		return noItemDetalleOrdenOT;
	}
	public void setNoItemDetalleOrdenOT(int noItemDetalleOrdenOT) {
		this.noItemDetalleOrdenOT = noItemDetalleOrdenOT;
	}
	public String getDescripcionActividadDetalleOrdenOT() {
		return descripcionActividadDetalleOrdenOT;
	}
	public void setDescripcionActividadDetalleOrdenOT(String descripcionActividadDetalleOrdenOT) {
		this.descripcionActividadDetalleOrdenOT = descripcionActividadDetalleOrdenOT;
	}
	public Date getFechaPlanificadaDetalleOrdenOT() {
		return fechaPlanificadaDetalleOrdenOT;
	}
	public void setFechaPlanificadaDetalleOrdenOT(Date fechaPlanificadaDetalleOrdenOT) {
		this.fechaPlanificadaDetalleOrdenOT = fechaPlanificadaDetalleOrdenOT;
	}
	public int getPuntosPlanificadosDetalleOrdenOT() {
		return puntosPlanificadosDetalleOrdenOT;
	}
	public void setPuntosPlanificadosDetalleOrdenOT(int puntosPlanificadosDetalleOrdenOT) {
		this.puntosPlanificadosDetalleOrdenOT = puntosPlanificadosDetalleOrdenOT;
	}
	public int getPuntosEjecutadosDetalleOrdenOT() {
		return puntosEjecutadosDetalleOrdenOT;
	}
	public void setPuntosEjecutadosDetalleOrdenOT(int puntosEjecutadosDetalleOrdenOT) {
		this.puntosEjecutadosDetalleOrdenOT = puntosEjecutadosDetalleOrdenOT;
	}
	

}
