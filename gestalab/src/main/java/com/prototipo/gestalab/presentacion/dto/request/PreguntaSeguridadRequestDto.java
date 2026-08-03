package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class PreguntaSeguridadRequestDto {
	
	@NotBlank(message = "El correo es obligatorio")
	private String correo;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
