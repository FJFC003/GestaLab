package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;


public class DetalleOrdenTrabajoOT {
	
	private int idDetalleOrdenOT;
	private Date fechaPlanificadaDetalleOrdenOT;
	private int puntosPlanificadosDetalleOrdenOT;
	private int puntosEjecutadosDetalleOrdenOT;
	public int getIdDetalleOrdenOT() {
		return idDetalleOrdenOT;
	}
	public void setIdDetalleOrdenOT(int idDetalleOrdenOT) {
		this.idDetalleOrdenOT = idDetalleOrdenOT;
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
