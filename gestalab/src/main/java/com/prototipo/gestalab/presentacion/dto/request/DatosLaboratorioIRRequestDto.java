package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DatosLaboratorioIRRequestDto {

	private int idDatos;
	@NotBlank
	private String organizacion;
	@NotBlank
	private String direccion;
	@NotBlank
	private String telefono;
	@NotBlank
	@Email(message = "El correo no tiene un formato válido")
	private String correo;

}
