package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InformeResultadosIRRequestDto {
	@NotBlank
	private int idInforme;
	@NotBlank
	private String notasAdvertencia;
	@NotBlank
	private String nombreResponsable;

}
