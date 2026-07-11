package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CondicionAmbientalIRRequestDto {
	@NotBlank
	private int idCondi;
	@NotBlank
	private String noAlicuota;
	@NotBlank
	private String horaToma;
	@NotBlank
	private String temperatura;
	@NotBlank
	private String humedad;
	@NotBlank
	private String precipitacion;

}
