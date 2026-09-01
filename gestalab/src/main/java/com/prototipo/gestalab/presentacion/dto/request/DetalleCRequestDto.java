package com.prototipo.gestalab.presentacion.dto.request;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class DetalleCRequestDto {

	private int idDetalleC;
	private int cantidadPuntosDetalleC;
	private double precioUnitarioDetalleC;
	private double precioTotalDetalleC;
	private String condicionDetalleC;
	private String frecuenciaDetalleC;
	private int fkCotizacion;
	private int fkDescripcionServicio;
	@Min(value = 1, message = "Debe seleccionar un plazo de entrega")
	private int fkPlazoEntrega;
	@Min(value = 1, message = "Debe seleccionar un tipo de toma de muestra")
	private int fkTipoTomaMuestra;

	// Ensayos / parametros que cubre este grupo de servicio.
	private List<DetalleParametroCRequestDto> listaParametros = new ArrayList<>();

}
