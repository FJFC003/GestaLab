package com.prototipo.gestalab.dominio.entidades;

public class ResultadosIR {
	
	private int idResultados;
	private int noItem;
	private String parametros;
	private String metodoReferencial;
	private String unidad;
	private String resultado;
	private String incertidumbre;
	private String LMP;
	private String conformidad;
	private InformeResultadosIR fkInforme;
	
	public int getNoItem() {
		return noItem;
	}
	public void setNoItem(int noItem) {
		this.noItem = noItem;
	}
	public InformeResultadosIR getFkInforme() {
		return fkInforme;
	}
	public void setFkInforme(InformeResultadosIR fkInforme) {
		this.fkInforme = fkInforme;
	}
	public int getIdResultados() {
		return idResultados;
	}
	public void setIdResultados(int idResultados) {
		this.idResultados = idResultados;
	}
	public String getParametros() {
		return parametros;
	}
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}
	public String getMetodoReferencial() {
		return metodoReferencial;
	}
	public void setMetodoReferencial(String metodoReferencial) {
		this.metodoReferencial = metodoReferencial;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getIncertidumbre() {
		return incertidumbre;
	}
	public void setIncertidumbre(String incertidumbre) {
		this.incertidumbre = incertidumbre;
	}
	public String getLMP() {
		return LMP;
	}
	public void setLMP(String lMP) {
		LMP = lMP;
	}
	public String getConformidad() {
		return conformidad;
	}
	public void setConformidad(String conformidad) {
		this.conformidad = conformidad;
	}
	

}
