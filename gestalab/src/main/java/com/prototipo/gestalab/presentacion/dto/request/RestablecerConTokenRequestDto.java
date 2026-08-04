package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class RestablecerConTokenRequestDto {
	
	@NotBlank(message = "El enlace no es válido")
	private String token;

	@NotBlank(message = "La nueva contraseña es obligatoria")
	private String nuevaContrasenia;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNuevaContrasenia() {
		return nuevaContrasenia;
	}

	public void setNuevaContrasenia(String nuevaContrasenia) {
		this.nuevaContrasenia = nuevaContrasenia;
	}

}
