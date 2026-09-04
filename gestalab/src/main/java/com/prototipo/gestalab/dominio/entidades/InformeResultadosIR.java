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
	// Limite maximo permisible que se cita en la nota 3 del formato F-PO-02-07.
	// Es el mismo catalogo LMP que usa la cotizacion, para que el informe no
	// pueda citar una norma que el area comercial desconoce.
	private LmpC fkLmp;
	private Date fechaIngresoLaboratorio;

	// Mapa del lugar de muestreo. Se guarda el contenido y su tipo MIME para
	// poder reconstruir la imagen tal cual se subio.
	private byte[] imagenMapa;
	private String imagenMapaTipo;

	// Cuando la Coordinacion Tecnica devuelve el informe al laboratorio, queda
	// registrado por que. Se conserva despues de corregido como historial de la
	// observacion.
	private String motivoDevolucion;
	private Date fechaDevolucionLaboratorio;
	
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
	public byte[] getImagenMapa() {
		return imagenMapa;
	}
	public void setImagenMapa(byte[] imagenMapa) {
		this.imagenMapa = imagenMapa;
	}
	public String getImagenMapaTipo() {
		return imagenMapaTipo;
	}
	public void setImagenMapaTipo(String imagenMapaTipo) {
		this.imagenMapaTipo = imagenMapaTipo;
	}
	public String getMotivoDevolucion() {
		return motivoDevolucion;
	}
	public void setMotivoDevolucion(String motivoDevolucion) {
		this.motivoDevolucion = motivoDevolucion;
	}
	public Date getFechaDevolucionLaboratorio() {
		return fechaDevolucionLaboratorio;
	}
	public void setFechaDevolucionLaboratorio(Date fechaDevolucionLaboratorio) {
		this.fechaDevolucionLaboratorio = fechaDevolucionLaboratorio;
	}
	public LmpC getFkLmp() {
		return fkLmp;
	}
	public void setFkLmp(LmpC fkLmp) {
		this.fkLmp = fkLmp;
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
