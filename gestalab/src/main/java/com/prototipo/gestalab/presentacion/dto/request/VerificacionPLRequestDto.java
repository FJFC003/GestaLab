package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VerificacionPLRequestDto {
	
	@NotBlank
	private int idVerificacion;
	@NotBlank
	private int noItem;
	@NotBlank
	private boolean tipoMatrizDeclarada;
	@NotBlank
	private boolean frecuanciaDeclarada;
	@NotBlank
	private boolean sitiosDeclarados;

}
