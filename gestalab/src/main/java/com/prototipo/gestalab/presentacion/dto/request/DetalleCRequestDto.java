package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetalleCRequestDto {
	
	private int idDetalleC;
	private String descripcionDetalleC;
	@NotBlank(message = "El plazo de entrega es obligatorio")
	private String plazoEntregaDetalleC;
	private int cantidadPuntosDetalleC;
	private double precioUnitarioDetalleC;
	private double precioTotalDetalleC;
	private String condicionDetalleC;
	private int fkCotizacion;
	private int fkParametro;
	private int fkNormaServicio;

}
