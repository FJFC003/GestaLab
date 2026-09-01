package com.prototipo.gestalab.presentacion.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DetalleCResponseDto {

	private int idDetalleC;
	private int cantidadPuntosDetalleC;
	private double precioUnitarioDetalleC;
	private double precioTotalDetalleC;
	private String condicionDetalleC;
	private String frecuenciaDetalleC;
	private DescripcionServicioCResponseDto fkDescripcionServicio;
	private PlazoEntregaCResponseDto fkPlazoEntrega;
	private TipoTomaMuestraCResponseDto fkTipoTomaMuestra;

	private List<DetalleParametroCResponseDto> listaParametros = new ArrayList<>();

	private CotizacionCResponseDto fkCotizacion;

}
