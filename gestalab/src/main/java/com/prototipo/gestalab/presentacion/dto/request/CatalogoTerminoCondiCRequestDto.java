package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CatalogoTerminoCondiCRequestDto {
	
	private int idTerminoC;
	@NotBlank
	private String tituloTerminoC;
	@NotBlank
	private String contenidoTerminoC;

}
