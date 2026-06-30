package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CargoRequestDto {
	
	@NotBlank
	private int idCargo;
	@NotBlank
	private String nombre;
	@NotBlank
	private String descripcion;
	@NotBlank
	private boolean estadoCargo;

}
