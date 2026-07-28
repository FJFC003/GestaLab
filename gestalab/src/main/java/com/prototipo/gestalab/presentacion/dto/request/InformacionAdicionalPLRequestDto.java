package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InformacionAdicionalPLRequestDto {

	private int idInformacion;
	@NotBlank(message = "La pregunta es obligatoria")
	private String preguntas;
	private String respuesta;
	@Positive(message = "Debe pertenecer a un plan de muestreo")
	private int fkPlanMuestreo;
	
}
