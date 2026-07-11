package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquiposUtilizadosIRRequestDto {
	@NotBlank
	private int idEquipos;
	@NotBlank
	private String nombre;
	@NotBlank
	private String marca;
	@NotBlank
	private String modelo;
	@NotBlank
	private String serie;
	@NotBlank
	private String codigoInterno;

}
