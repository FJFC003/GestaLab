package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class RestablecerAccesoRequestDto {
	
	@NotBlank(message = "El correo es obligatorio")
	private String correo;

	@NotBlank(message = "La respuesta es obligatoria")
	private String respuesta;

	@NotBlank(message = "La nueva contrasena es obligatoria")
	private String nuevaContrasenia;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getNuevaContrasenia() {
		return nuevaContrasenia;
	}

	public void setNuevaContrasenia(String nuevaContrasenia) {
		this.nuevaContrasenia = nuevaContrasenia;
	}

}
