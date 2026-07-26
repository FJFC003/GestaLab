package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LmpCRequestDto {
	
	private int idLmpC;
	@NotBlank
	private String codigoLmpC;
	@NotBlank
	private String valorLmpC;

}
