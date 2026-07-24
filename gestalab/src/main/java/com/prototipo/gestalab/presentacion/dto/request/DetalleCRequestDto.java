package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetalleCRequestDto {
	
	private int idDetalleC;
	@NotBlank
	private String descripcionDetalleC;
	@NotBlank
	private String plazoEntregaDetalleC;
	private int cantidadPuntosDetalleC;
	private double precioUnitarioDetalleC;
	private double precioTotalDetalleC;
	@NotBlank
	private String condicionDetalleC;
	private int fkCotizacion;
	private int fkParametro;
	private int fkNormaServicio;

}
