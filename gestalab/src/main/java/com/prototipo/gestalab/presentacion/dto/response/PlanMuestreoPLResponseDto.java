package com.prototipo.gestalab.presentacion.dto.response;

import java.util.Date;

public class PlanMuestreoPLResponseDto {
	
	private int idPlan;
	private String codigoPlan;
	private String ObjetivoPlan;
	private Date fechaElaboracion;
	private EmpleadoResponseDto fkResponsable;
	private DetalleCResponseDto fkDetalleCotizacion;

	public int getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}
	public String getCodigoPlan() {
		return codigoPlan;
	}
	public void setCodigoPlan(String codigoPlan) {
		this.codigoPlan = codigoPlan;
	}
	public String getObjetivoPlan() {
		return ObjetivoPlan;
	}
	public void setObjetivoPlan(String objetivoPlan) {
		ObjetivoPlan = objetivoPlan;
	}
	public Date getFechaElaboracion() {
		return fechaElaboracion;
	}
	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}
	public EmpleadoResponseDto getFkResponsable() {
		return fkResponsable;
	}
	public void setFkResponsable(EmpleadoResponseDto fkResponsable) {
		this.fkResponsable = fkResponsable;
	}
	public DetalleCResponseDto getFkDetalleCotizacion() {
		return fkDetalleCotizacion;
	}
	public void setFkDetalleCotizacion(DetalleCResponseDto fkDetalleCotizacion) {
		this.fkDetalleCotizacion = fkDetalleCotizacion;
	}
	
}
