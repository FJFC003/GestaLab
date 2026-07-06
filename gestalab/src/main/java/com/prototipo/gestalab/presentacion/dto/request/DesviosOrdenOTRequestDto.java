package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DesviosOrdenOTRequestDto {
	
	@NotBlank
	private int idDesviosOrdenOT;
	@NotBlank
	private String descripcionDesviosOrdenOT;
	@NotBlank
	private int puntosModificadosDesviosOrdenOT;

}
