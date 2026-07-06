package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CotizacionCRequestDto {
	
	@NotBlank
	private int idCotizacionC;
	@NotBlank
	private Date fechaElaboracionCotizacionC;
	@NotBlank
	private String vigenciaDiasCotizacionC;
	@NotBlank
	private String elaboradoPorCotizacionC;
	@NotBlank
	private double subtotalAgua;
	@NotBlank
	private double subtotalRuido;
	@NotBlank
	private double subtotalEmiciones;
	@NotBlank
	private double subtotalCalidad;
	@NotBlank
	private double subtotalSuelo;
	@NotBlank
	private double costoLogistica;
	@NotBlank
	private double Iva;
	@NotBlank
	private double TotalCotizacionC;

}
