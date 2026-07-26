package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlazoEntregaCRequestDto {
	
	private int idPlazoEntregaC;
	@NotBlank
	private String codigoPlazoEntregaC;
	@NotBlank
	private String textoPlazoEntregaC;

}
