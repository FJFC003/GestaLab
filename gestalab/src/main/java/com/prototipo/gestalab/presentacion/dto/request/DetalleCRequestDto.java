package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetalleCRequestDto {
	
	@NotBlank
	private int idDetalleC;
	@NotBlank
	private String descripcionDetalleC;
	@NotBlank
	private String plazoEntregaDetalleC;
	@NotBlank
	private int cantidadPuntosDetalleC;
	@NotBlank
	private double precioUnitarioDetalleC;
	@NotBlank
	private double precioTotalDetalleC;
	@NotBlank
	private String condicionDetalleC;

}
