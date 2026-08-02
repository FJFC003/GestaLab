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

}
