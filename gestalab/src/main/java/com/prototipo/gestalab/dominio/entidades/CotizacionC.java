package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;


public class CotizacionC {
	
	private int idCotizacionC;
	private Date fechaElaboracionCotizacionC;
	private String vigenciaDiasCotizacionC;
	private String elaboradoPorCotizacionC;
	private double subtotalAgua;
	private double subtotalRuido;
	private double subtotalEmiciones;
	private double subtotalCalidad;
	private double subtotalSuelo;
	private double costoLogistica;
	private double Iva;
	private double TotalCotizacionC;
	
	

	public CotizacionC(int idCotizacionC, Date fechaElaboracionCotizacionC, String vigenciaDiasCotizacionC,
			String elaboradoPorCotizacionC, double subtotalAgua, double subtotalRuido, double subtotalEmiciones,
			double subtotalCalidad, double subtotalSuelo, double costoLogistica, double iva, double totalCotizacionC) {
		super();
		this.idCotizacionC = idCotizacionC;
		this.fechaElaboracionCotizacionC = fechaElaboracionCotizacionC;
		this.vigenciaDiasCotizacionC = vigenciaDiasCotizacionC;
		this.elaboradoPorCotizacionC = elaboradoPorCotizacionC;
		this.subtotalAgua = subtotalAgua;
		this.subtotalRuido = subtotalRuido;
		this.subtotalEmiciones = subtotalEmiciones;
		this.subtotalCalidad = subtotalCalidad;
		this.subtotalSuelo = subtotalSuelo;
		this.costoLogistica = costoLogistica;
		Iva = iva;
		TotalCotizacionC = totalCotizacionC;
	}

	public int getIdCotizacionC() {
		return idCotizacionC;
	}

	public void setIdCotizacionC(int idCotizacionC) {
		this.idCotizacionC = idCotizacionC;
	}

	public Date getFechaElaboracionCotizacionC() {
		return fechaElaboracionCotizacionC;
	}

	public void setFechaElaboracionCotizacionC(Date fechaElaboracionCotizacionC) {
		this.fechaElaboracionCotizacionC = fechaElaboracionCotizacionC;
	}

	public String getVigenciaDiasCotizacionC() {
		return vigenciaDiasCotizacionC;
	}

	public void setVigenciaDiasCotizacionC(String vigenciaDiasCotizacionC) {
		this.vigenciaDiasCotizacionC = vigenciaDiasCotizacionC;
	}

	public String getElaboradoPorCotizacionC() {
		return elaboradoPorCotizacionC;
	}

	public void setElaboradoPorCotizacionC(String elaboradoPorCotizacionC) {
		this.elaboradoPorCotizacionC = elaboradoPorCotizacionC;
	}

	public double getSubtotalAgua() {
		return subtotalAgua;
	}

	public void setSubtotalAgua(double subtotalAgua) {
		this.subtotalAgua = subtotalAgua;
	}

	public double getSubtotalRuido() {
		return subtotalRuido;
	}

	public void setSubtotalRuido(double subtotalRuido) {
		this.subtotalRuido = subtotalRuido;
	}

	public double getSubtotalEmiciones() {
		return subtotalEmiciones;
	}

	public void setSubtotalEmiciones(double subtotalEmiciones) {
		this.subtotalEmiciones = subtotalEmiciones;
	}

	public double getSubtotalCalidad() {
		return subtotalCalidad;
	}

	public void setSubtotalCalidad(double subtotalCalidad) {
		this.subtotalCalidad = subtotalCalidad;
	}

	public double getSubtotalSuelo() {
		return subtotalSuelo;
	}

	public void setSubtotalSuelo(double subtotalSuelo) {
		this.subtotalSuelo = subtotalSuelo;
	}

	public double getCostoLogistica() {
		return costoLogistica;
	}

	public void setCostoLogistica(double costoLogistica) {
		this.costoLogistica = costoLogistica;
	}

	public double getIva() {
		return Iva;
	}

	public void setIva(double iva) {
		Iva = iva;
	}

	public double getTotalCotizacionC() {
		return TotalCotizacionC;
	}

	public void setTotalCotizacionC(double totalCotizacionC) {
		TotalCotizacionC = totalCotizacionC;
	}
	
	

}
