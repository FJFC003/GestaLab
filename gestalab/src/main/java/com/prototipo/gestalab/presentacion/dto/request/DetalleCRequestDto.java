package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class DetalleCRequestDto {
	
	private int idDetalleC;
	private int cantidadPuntosDetalleC;
	private double precioUnitarioDetalleC;
	private double precioTotalDetalleC;
	private String condicionDetalleC;
	private int fkCotizacion;
	private int fkParametro;
	private int fkLmp;
	private int fkDescripcionServicio;
	@Min(value = 1, message = "Debe seleccionar un plazo de entrega")
	private int fkPlazoEntrega;

}
