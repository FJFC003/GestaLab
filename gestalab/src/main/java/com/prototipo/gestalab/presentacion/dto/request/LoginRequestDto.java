package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class LoginRequestDto {

		@NotBlank
		private String correo;
		@NotBlank
		private String contrasenia;

}

