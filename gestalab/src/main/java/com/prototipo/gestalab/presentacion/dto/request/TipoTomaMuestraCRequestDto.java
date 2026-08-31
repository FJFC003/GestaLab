package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TipoTomaMuestraCRequestDto {

	private int idTipoTomaMuestraC;
	@NotBlank
	private String codigoTipoTomaMuestraC;
	@NotBlank
	private String textoTipoTomaMuestraC;
	private String observacionTipoTomaMuestraC;

}
