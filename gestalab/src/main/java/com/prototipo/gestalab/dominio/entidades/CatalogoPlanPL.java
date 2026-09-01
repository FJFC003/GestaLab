package com.prototipo.gestalab.dominio.entidades;

import lombok.Data;

/**
 * Opciones de las listas desplegables del formato F-PO-02-01 Plan de Muestreo.
 *
 * Las cinco listas del formato (tipo de matriz, frecuencia, sitio de medicion,
 * preservacion y recursos) tienen la misma estructura y pocos valores cada una,
 * por eso comparten tabla y se distinguen por tipoLista en vez de tener cinco
 * tablas y cinco pantallas de administracion.
 *
 * El plan guarda el texto de la opcion, no su id: asi los planes llenados antes
 * de existir el catalogo siguen siendo legibles y los PDF no cambian.
 */
@Data
public class CatalogoPlanPL {

	public static final String TIPO_MATRIZ = "TIPO_MATRIZ";
	public static final String FRECUENCIA = "FRECUENCIA";
	public static final String SITIO_MEDICION = "SITIO_MEDICION";
	public static final String PRESERVACION = "PRESERVACION";
	public static final String RECURSO = "RECURSO";

	private int idCatalogoPlanPL;
	private String tipoLista;
	private String valorCatalogoPlanPL;
	private String descripcionCatalogoPlanPL;
	private int ordenCatalogoPlanPL;
	private boolean estadoCatalogoPlanPL;

}
