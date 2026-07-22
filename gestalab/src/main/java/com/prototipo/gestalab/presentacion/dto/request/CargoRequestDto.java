package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CargoRequestDto {
	
	private int idCargo;
	@NotBlank
	private String nombre;
	@NotBlank
	private String descripcion;
	private boolean estadoCargo;

}
