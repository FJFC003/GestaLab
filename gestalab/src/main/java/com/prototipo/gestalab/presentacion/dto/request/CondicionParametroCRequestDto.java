package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CondicionParametroCRequestDto {
	
	private int idCondicionParametroC;
	@NotBlank
	private String codigoCondicionParametroC;
	@NotBlank
	private String descripcionCondicionParametroC;

}
