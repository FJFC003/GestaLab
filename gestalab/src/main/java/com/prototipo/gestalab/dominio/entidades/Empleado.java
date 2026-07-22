package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;

public class Empleado {
	
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private String ci;
	private String correo;
	private String direccion;
	private Date fechaIngreso;
	private Date fechaSalida;
	private boolean estadoEmpleado;
	private Area fkArea;
	private Cargo fkCargo;
	private FirmaElectronica fkFirmaElectronica;
	private Usuario fkUsuario;
	public Empleado(int idEmpleado, String nombre, String apellido, String ci, String correo, String direccion,
			Date fechaIngreso, Date fechaSalida, boolean estadoEmpleado, Area fkArea, Cargo fkCargo,
			FirmaElectronica fkFirmaElectronica, Usuario fkUsuario) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.correo = correo;
		this.direccion = direccion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.estadoEmpleado = estadoEmpleado;
		this.fkArea = fkArea;
		this.fkCargo = fkCargo;
		this.fkFirmaElectronica = fkFirmaElectronica;
		this.fkUsuario = fkUsuario;
	}
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public Area getFkArea() {
		return fkArea;
	}
	public void setFkArea(Area fkArea) {
		this.fkArea = fkArea;
	}
	public Cargo getFkCargo() {
		return fkCargo;
	}
	public void setFkCargo(Cargo fkCargo) {
		this.fkCargo = fkCargo;
	}
	public FirmaElectronica getFkFirmaElectronica() {
		return fkFirmaElectronica;
	}
	public void setFkFirmaElectronica(FirmaElectronica fkFirmaElectronica) {
		this.fkFirmaElectronica = fkFirmaElectronica;
	}
	public Usuario getFkUsuario() {
		return fkUsuario;
	}
	public void setFkUsuario(Usuario fkUsuario) {
		this.fkUsuario = fkUsuario;
	}
	
}
