package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CambioContraseniaRequestDto {
	
	@NotBlank(message = "La contraseña es obligatoria")
	private String contrasenia;


}
