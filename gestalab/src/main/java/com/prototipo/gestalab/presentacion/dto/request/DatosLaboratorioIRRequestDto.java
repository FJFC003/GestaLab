package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DatosLaboratorioIRRequestDto {
	@NotBlank
	private int idDatos;
	@NotBlank
	private String organizacion;
	@NotBlank
	private String direccion;
	@NotBlank
	private String telefono;
	@NotBlank
	private String correo;

}
