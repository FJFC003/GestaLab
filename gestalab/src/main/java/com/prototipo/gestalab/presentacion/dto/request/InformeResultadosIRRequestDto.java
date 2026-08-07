package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InformeResultadosIRRequestDto {
	
	private int idInforme;

	@NotBlank(message = "El código del informe es obligatorio")
	private String codigoInforme;

	private Date fechaEmisionInforme;

	private String notasAdvertencia;

	@NotBlank(message = "El responsable del análisis es obligatorio")
	private String nombreResponsable;

	@NotBlank(message = "Debe indicar si cumple o no la normativa")
	private String conformidadGeneral;

	private int fkDatosLaboratorio;

	@Positive(message = "El informe debe pertenecer a una orden de trabajo")
	private int fkOrdenTrabajo;

	// ---- Informacion del sitio de muestreo ----
	// Sin validaciones: son datos que el laboratorio completa cuando los
	// tiene, y el informe se guarda como borrador antes de tenerlos todos.
	private String identificacionSitioMuestreo;
	private String coordenadaUtmX;
	private String coordenadaUtmY;
	private String codigoCadenaCustodia;
	private String codigoLaboratorio;
	private String procedimientoTomaMuestra;
	private Date fechaIngresoLaboratorio;

}
