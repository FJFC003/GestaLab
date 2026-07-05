package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InformacionAdicionalPLRequestDto {

	@NotBlank
	private int idInformacion;
	@NotBlank
	private String preguntas;
	@NotBlank
	private String respuesta;
	
}
