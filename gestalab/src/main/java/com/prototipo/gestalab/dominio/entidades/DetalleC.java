package com.prototipo.gestalab.dominio.entidades;

import lombok.Data;

@Data
public class DetalleC {
	
	private int idDetalleC;
	private int cantidadPuntosDetalleC;
	private double precioUnitarioDetalleC;
	private double precioTotalDetalleC;
	private String condicionDetalleC;
	private CotizacionC fkCotizacion;
	private CatalogoParametroC fkParametro;
	private LmpC fkLmp;
	private DescripcionServicioC fkDescripcionServicio;
	private PlazoEntregaC fkPlazoEntrega;


}
