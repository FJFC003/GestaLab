package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class SolicitarRecuperacionRequestDto {
	
	@NotBlank(message = "El correo laboral es obligatorio")
	private String correo;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
