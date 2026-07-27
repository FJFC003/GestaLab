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
	private boolean estadoCotizacionC;
	
	private EstadoAprobacionCotizacion estadoAprobacion;
	private Date fechaEnvioCotizacionC;
	private Date fechaLimitePagoCotizacionC;
	private Date fechaPagoCotizacionC;
	private Date fechaAprobacionCotizacionC;
	private Empleado fkEmpleadoAprueba;
	
	public EstadoAprobacionCotizacion getEstadoAprobacion() {
		return estadoAprobacion;
	}

	public void setEstadoAprobacion(EstadoAprobacionCotizacion estadoAprobacion) {
		this.estadoAprobacion = estadoAprobacion;
	}

	public Date getFechaEnvioCotizacionC() {
		return fechaEnvioCotizacionC;
	}

	public void setFechaEnvioCotizacionC(Date fechaEnvioCotizacionC) {
		this.fechaEnvioCotizacionC = fechaEnvioCotizacionC;
	}

	public Date getFechaLimitePagoCotizacionC() {
		return fechaLimitePagoCotizacionC;
	}

	public void setFechaLimitePagoCotizacionC(Date fechaLimitePagoCotizacionC) {
		this.fechaLimitePagoCotizacionC = fechaLimitePagoCotizacionC;
	}

	public Date getFechaPagoCotizacionC() {
		return fechaPagoCotizacionC;
	}

	public void setFechaPagoCotizacionC(Date fechaPagoCotizacionC) {
		this.fechaPagoCotizacionC = fechaPagoCotizacionC;
	}

	public Date getFechaAprobacionCotizacionC() {
		return fechaAprobacionCotizacionC;
	}

	public void setFechaAprobacionCotizacionC(Date fechaAprobacionCotizacionC) {
		this.fechaAprobacionCotizacionC = fechaAprobacionCotizacionC;
	}

	public Empleado getFkEmpleadoAprueba() {
		return fkEmpleadoAprueba;
	}

	public void setFkEmpleadoAprueba(Empleado fkEmpleadoAprueba) {
		this.fkEmpleadoAprueba = fkEmpleadoAprueba;
	}

	public boolean isEstadoCotizacionC() {
		return estadoCotizacionC;
	}

	public void setEstadoCotizacionC(boolean estadoCotizacionC) {
		this.estadoCotizacionC = estadoCotizacionC;
	}

	private ClienteC fkCliente;
	
	private Empleado fkEmpleado;
	
	

	public ClienteC getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(ClienteC fkCliente) {
		this.fkCliente = fkCliente;
	}

	

	public Empleado getFkEmpleado() {
		return fkEmpleado;
	}

	public void setFkEmpleado(Empleado fkEmpleado) {
		this.fkEmpleado = fkEmpleado;
	}

	private CatalogoNormServiC fkNormaServicio;
	private LmpC fkLmp;

	public CatalogoNormServiC getFkNormaServicio() {
		return fkNormaServicio;
	}

	public void setFkNormaServicio(CatalogoNormServiC fkNormaServicio) {
		this.fkNormaServicio = fkNormaServicio;
	}

	public LmpC getFkLmp() {
		return fkLmp;
	}

	public void setFkLmp(LmpC fkLmp) {
		this.fkLmp = fkLmp;
	}

	public CotizacionC() {
		super();
		// TODO Auto-generated constructor stub
	}

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
