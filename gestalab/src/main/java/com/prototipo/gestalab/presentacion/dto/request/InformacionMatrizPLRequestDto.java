package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InformacionMatrizPLRequestDto {
	@NotBlank
	private int idInfoMatriz;
	@NotBlank
	private int noItem;
	@NotBlank
	private String tipoMatriz;
	@NotBlank
	private String Ubicacion;
	@NotBlank
	private String descripcionDelPunto;
	@NotBlank
	private String Accesibilidad;

}
