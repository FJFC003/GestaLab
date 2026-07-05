package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TipoTomaFreHoraPLRequestDto {
	
	@NotBlank
	private int idTipoFre;
	@NotBlank
	private int noItem;
	@NotBlank
	private String tipo;
	@NotBlank
	private String alicuotas;

}
