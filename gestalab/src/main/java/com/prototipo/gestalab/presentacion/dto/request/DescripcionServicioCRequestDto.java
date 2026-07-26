package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DescripcionServicioCRequestDto {
	
	private int idDescripcionServicioC;
	@NotBlank
	private String codigoDescripcionServicioC;
	@NotBlank
	private String textoDescripcionServicioC;

}
