package com.prototipo.gestalab.dominio.entidades;

public class EquipoLaboratorio {
	
	private int idEquipoLab;
	private String nombre;
	private String marca;
	private String modelo;
	private String serie;
	private String codigoInterno;
	private boolean estadoEquipoLab;
	
	public int getIdEquipoLab() {
		return idEquipoLab;
	}
	public void setIdEquipoLab(int idEquipoLab) {
		this.idEquipoLab = idEquipoLab;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getCodigoInterno() {
		return codigoInterno;
	}
	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
	public boolean isEstadoEquipoLab() {
		return estadoEquipoLab;
	}
	public void setEstadoEquipoLab(boolean estadoEquipoLab) {
		this.estadoEquipoLab = estadoEquipoLab;
	}

}
