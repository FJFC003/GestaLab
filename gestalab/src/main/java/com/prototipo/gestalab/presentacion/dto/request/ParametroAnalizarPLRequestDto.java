package com.prototipo.gestalab.presentacion.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ParametroAnalizarPLRequestDto {
	@NotBlank
	private int idParametroPL;
	@NotBlank
	private int noParametroPL;
	@NotBlank
	private String Parametros;

}
