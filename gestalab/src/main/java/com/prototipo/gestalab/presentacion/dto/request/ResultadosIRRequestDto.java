package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResultadosIRRequestDto {
	
	@NotBlank
	private int idResultados;
	@NotBlank
	private String parametros;
	@NotBlank
	private String metodoReferencial;
	@NotBlank
	private String unidad;
	@NotBlank
	private String resultado;
	@NotBlank
	private String incertidumbre;
	@NotBlank
	private String LMP;
	@NotBlank
	private String conformidad;

}
