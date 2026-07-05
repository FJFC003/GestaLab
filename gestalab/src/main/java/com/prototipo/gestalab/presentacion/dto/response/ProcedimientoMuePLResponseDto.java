package com.prototipo.gestalab.presentacion.dto.response;

public class ProcedimientoMuePLResponseDto {
	
	private int idProcedimiento;
	private int noItem;
	private String Tipo;
	private String descripcion;
	private String precausiones;
	
	public int getIdProcedimiento() {
		return idProcedimiento;
	}
	public void setIdProcedimiento(int idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}
	public int getNoItem() {
		return noItem;
	}
	public void setNoItem(int noItem) {
		this.noItem = noItem;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecausiones() {
		return precausiones;
	}
	public void setPrecausiones(String precausiones) {
		this.precausiones = precausiones;
	}
	
	

}
