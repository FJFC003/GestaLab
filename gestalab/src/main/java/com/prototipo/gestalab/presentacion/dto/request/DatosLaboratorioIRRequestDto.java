package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DatosLaboratorioIRRequestDto {

	private int idDatos;

	@NotBlank(message = "La organización es obligatoria")
	private String organizacion;

	@NotBlank(message = "La dirección es obligatoria")
	private String direccion;

	@NotBlank(message = "El teléfono es obligatorio")
	private String telefono;

	@NotBlank(message = "El correo es obligatorio")
	@Email(message = "El correo no tiene un formato válido")
	private String correo;

}
