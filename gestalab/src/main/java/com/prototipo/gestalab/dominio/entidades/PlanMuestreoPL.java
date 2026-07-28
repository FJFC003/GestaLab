package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;

public class PlanMuestreoPL {
	
	private int idPlan;
	private String codigoPlan;
	private String ObjetivoPlan;
	private Date fechaElaboracion;
	private Empleado fkResponsable;
	private DetalleC fkDetalleCotizacion;
	private EEPPL fkeep;
	private EstadoPlanMuestreo estadoPlan;
	private Date fechaEnvioTecnico;
	
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
	public Empleado getFkResponsable() {
		return fkResponsable;
	}
	public void setFkResponsable(Empleado fkResponsable) {
		this.fkResponsable = fkResponsable;
	}
	public DetalleC getFkDetalleCotizacion() {
		return fkDetalleCotizacion;
	}
	public void setFkDetalleCotizacion(DetalleC fkDetalleCotizacion) {
		this.fkDetalleCotizacion = fkDetalleCotizacion;
	}
	public EEPPL getFkeep() {
		return fkeep;
	}
	public void setFkeep(EEPPL fkeep) {
		this.fkeep = fkeep;
	}
	public EstadoPlanMuestreo getEstadoPlan() {
		return estadoPlan;
	}
	public void setEstadoPlan(EstadoPlanMuestreo estadoPlan) {
		this.estadoPlan = estadoPlan;
	}
	public Date getFechaEnvioTecnico() {
		return fechaEnvioTecnico;
	}
	public void setFechaEnvioTecnico(Date fechaEnvioTecnico) {
		this.fechaEnvioTecnico = fechaEnvioTecnico;
	}

	
	

}
