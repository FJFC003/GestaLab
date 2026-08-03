package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ConfigurarPreguntaRequestDto {
	
	@NotBlank(message = "Debe elegir una pregunta de seguridad")
	private String pregunta;

	@NotBlank(message = "La respuesta es obligatoria")
	private String respuesta;

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
