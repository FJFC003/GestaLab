package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;

public class InformeResultadosIR {
	
	private int idInforme;
	private String codigoInforme;
	private Date fechaEmisionInforme;
	private String notasAdvertencia;
	private String nombreResponsable;
	private String conformidadGeneral;
	private DatosLaboratorioIR fkDatosLaboratorio;
	private OrdenTrabajoOT fkOrdenTrabajo;
	private EstadoInformeIR estadoInforme;
	private Date fechaEnvioCoordinacion;
	
	private String identificacionSitioMuestreo;
	private String coordenadaUtmX;
	private String coordenadaUtmY;
	private String codigoCadenaCustodia;
	private String codigoLaboratorio;
	private String procedimientoTomaMuestra;
	private Date fechaIngresoLaboratorio;
	
	public String getIdentificacionSitioMuestreo() {
		return identificacionSitioMuestreo;
	}
	public void setIdentificacionSitioMuestreo(String identificacionSitioMuestreo) {
		this.identificacionSitioMuestreo = identificacionSitioMuestreo;
	}
	public String getCoordenadaUtmX() {
		return coordenadaUtmX;
	}
	public void setCoordenadaUtmX(String coordenadaUtmX) {
		this.coordenadaUtmX = coordenadaUtmX;
	}
	public String getCoordenadaUtmY() {
		return coordenadaUtmY;
	}
	public void setCoordenadaUtmY(String coordenadaUtmY) {
		this.coordenadaUtmY = coordenadaUtmY;
	}
	public String getCodigoCadenaCustodia() {
		return codigoCadenaCustodia;
	}
	public void setCodigoCadenaCustodia(String codigoCadenaCustodia) {
		this.codigoCadenaCustodia = codigoCadenaCustodia;
	}
	public String getCodigoLaboratorio() {
		return codigoLaboratorio;
	}
	public void setCodigoLaboratorio(String codigoLaboratorio) {
		this.codigoLaboratorio = codigoLaboratorio;
	}
	public String getProcedimientoTomaMuestra() {
		return procedimientoTomaMuestra;
	}
	public void setProcedimientoTomaMuestra(String procedimientoTomaMuestra) {
		this.procedimientoTomaMuestra = procedimientoTomaMuestra;
	}
	public Date getFechaIngresoLaboratorio() {
		return fechaIngresoLaboratorio;
	}
	public void setFechaIngresoLaboratorio(Date fechaIngresoLaboratorio) {
		this.fechaIngresoLaboratorio = fechaIngresoLaboratorio;
	}
	public EstadoInformeIR getEstadoInforme() {
		return estadoInforme;
	}
	public void setEstadoInforme(EstadoInformeIR estadoInforme) {
		this.estadoInforme = estadoInforme;
	}
	public Date getFechaEnvioCoordinacion() {
		return fechaEnvioCoordinacion;
	}
	public void setFechaEnvioCoordinacion(Date fechaEnvioCoordinacion) {
		this.fechaEnvioCoordinacion = fechaEnvioCoordinacion;
	}
	public int getIdInforme() {
		return idInforme;
	}
	public void setIdInforme(int idInforme) {
		this.idInforme = idInforme;
	}
	public String getCodigoInforme() {
		return codigoInforme;
	}
	public void setCodigoInforme(String codigoInforme) {
		this.codigoInforme = codigoInforme;
	}
	public Date getFechaEmisionInforme() {
		return fechaEmisionInforme;
	}
	public void setFechaEmisionInforme(Date fechaEmisionInforme) {
		this.fechaEmisionInforme = fechaEmisionInforme;
	}
	public String getNotasAdvertencia() {
		return notasAdvertencia;
	}
	public void setNotasAdvertencia(String notasAdvertencia) {
		this.notasAdvertencia = notasAdvertencia;
	}
	public String getNombreResponsable() {
		return nombreResponsable;
	}
	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}
	public String getConformidadGeneral() {
		return conformidadGeneral;
	}
	public void setConformidadGeneral(String conformidadGeneral) {
		this.conformidadGeneral = conformidadGeneral;
	}
	public DatosLaboratorioIR getFkDatosLaboratorio() {
		return fkDatosLaboratorio;
	}
	public void setFkDatosLaboratorio(DatosLaboratorioIR fkDatosLaboratorio) {
		this.fkDatosLaboratorio = fkDatosLaboratorio;
	}
	public OrdenTrabajoOT getFkOrdenTrabajo() {
		return fkOrdenTrabajo;
	}
	public void setFkOrdenTrabajo(OrdenTrabajoOT fkOrdenTrabajo) {
		this.fkOrdenTrabajo = fkOrdenTrabajo;
	}

}
