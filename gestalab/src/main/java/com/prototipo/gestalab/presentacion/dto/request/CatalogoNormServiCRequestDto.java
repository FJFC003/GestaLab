package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CatalogoNormServiCRequestDto {
	
	@NotBlank
	private int idCatalogoNormServi;
	@NotBlank
	private String parametroCatalogoNormServiEntity;
	@NotBlank
	private String lmpCatalogoNormServiEntity;

}
