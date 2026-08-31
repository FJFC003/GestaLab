package com.prototipo.gestalab.dominio.entidades;

import lombok.Data;

/**
 * Un ensayo / parametro dentro de una linea de detalle de cotizacion.
 *
 * Una descripcion de servicio (DetalleC) agrupa varios parametros y comparte
 * para todos ellos el tipo de toma de muestra, el plazo de entrega, la cantidad
 * de puntos y la condicion. Por eso el parametro vive aqui y no en DetalleC.
 */
@Data
public class DetalleParametroC {

	private int idDetalleParametroC;
	private CatalogoParametroC fkParametro;
	private LmpC fkLmp;

}
