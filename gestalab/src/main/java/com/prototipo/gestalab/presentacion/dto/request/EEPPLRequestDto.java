package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EEPPLRequestDto {
	
	@NotBlank
	private int idEEP;
	@NotBlank
	private boolean chaleco;
	@NotBlank
	private boolean gafas;
	@NotBlank
	private boolean casco;
	@NotBlank
	private boolean mandil;
	@NotBlank
	private boolean mascarilla;
	@NotBlank
	private boolean botas;
	@NotBlank
	private boolean zapatos;
	@NotBlank
	private boolean accesoProPrivada;

}
