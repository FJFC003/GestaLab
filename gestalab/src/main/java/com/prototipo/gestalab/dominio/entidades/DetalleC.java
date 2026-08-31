package com.prototipo.gestalab.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Linea de detalle de una cotizacion, entendida como un grupo de servicio.
 *
 * Regla del negocio: una descripcion de servicio agrupa varios ensayos /
 * parametros y para todos ellos rige un mismo tipo de toma de muestra, un mismo
 * plazo de entrega, una misma cantidad de puntos y una misma condicion. Los
 * parametros viven en la lista de hijos, no en esta clase.
 */
@Data
public class DetalleC {

	private int idDetalleC;
	private int cantidadPuntosDetalleC;
	private double precioUnitarioDetalleC;
	private double precioTotalDetalleC;
	private String condicionDetalleC;
	private CotizacionC fkCotizacion;
	private DescripcionServicioC fkDescripcionServicio;
	private PlazoEntregaC fkPlazoEntrega;
	private TipoTomaMuestraC fkTipoTomaMuestra;

	private List<DetalleParametroC> listaParametros = new ArrayList<>();

}
