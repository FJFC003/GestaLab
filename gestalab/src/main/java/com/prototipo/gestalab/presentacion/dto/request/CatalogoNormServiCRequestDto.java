package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CatalogoNormServiCRequestDto {
	
	private int idCatalogoNormServi;
	@NotBlank
	@Size(max = 255, message = "El nombre de la norma no puede superar los 255 caracteres")
	private String nombreCatalogoNormServiEntity;

}
