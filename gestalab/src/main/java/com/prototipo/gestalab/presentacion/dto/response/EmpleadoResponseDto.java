package com.prototipo.gestalab.presentacion.dto.response;

import java.util.Date;

public class EmpleadoResponseDto {
	
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private String ci;
	private String correo;
	private String direccion;
	private Date fechaIngreso;
	private Date fechaSalida;
	private boolean estadoEmpleado;
	private AreaResponseDto fkArea;
	private CargoResponseDto fkCargo;
	private FirmaElectronicaResponseDto fkFirmaElectronica;
	private UsuarioResponseDto fkUsuario;
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public boolean isEstadoEmpleado() {
		return estadoEmpleado;
	}
	public void setEstadoEmpleado(boolean estadoEmpleado) {
		this.estadoEmpleado = estadoEmpleado;
	}
	public AreaResponseDto getFkArea() {
		return fkArea;
	}
	public void setFkArea(AreaResponseDto fkArea) {
		this.fkArea = fkArea;
	}
	public CargoResponseDto getFkCargo() {
		return fkCargo;
	}
	public void setFkCargo(CargoResponseDto fkCargo) {
		this.fkCargo = fkCargo;
	}
	public FirmaElectronicaResponseDto getFkFirmaElectronica() {
		return fkFirmaElectronica;
	}
	public void setFkFirmaElectronica(FirmaElectronicaResponseDto fkFirmaElectronica) {
		this.fkFirmaElectronica = fkFirmaElectronica;
	}
	public UsuarioResponseDto getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(UsuarioResponseDto fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

}
