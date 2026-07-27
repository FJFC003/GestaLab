package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import com.prototipo.gestalab.dominio.entidades.EstadoAprobacionCotizacion;

import lombok.Data;

@Data
public class CotizacionCRequestDto {
	
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
	private int fkCliente;
	private boolean estadoCotizacionC;
	private int fkEmpleado;
	private int fkNormaServicio;
	private int fkLmp;
	
	private EstadoAprobacionCotizacion estadoAprobacion;
	private Date fechaEnvioCotizacionC;
	private Date fechaLimitePagoCotizacionC;

}
