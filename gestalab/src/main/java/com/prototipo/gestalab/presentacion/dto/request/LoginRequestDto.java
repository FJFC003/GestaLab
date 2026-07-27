package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class LoginRequestDto {

		@NotBlank
		@Email(message = "El correo no tiene un formato válido")
		private String correo;
		@NotBlank
		private String contrasenia;

}

