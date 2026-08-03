package com.prototipo.gestalab.presentacion.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecuperacionAccesoUseCase;
import com.prototipo.gestalab.presentacion.dto.request.ConfigurarPreguntaRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.PreguntaSeguridadRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.RestablecerAccesoRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.PreguntaSeguridadResponseDto;

import jakarta.validation.Valid;


@RequestMapping("/api/gestalab/recuperacion")
@RestController
public class RecuperacionAccesoController {
	
	private final IRecuperacionAccesoUseCase recuperacionUseCase;

	public RecuperacionAccesoController(IRecuperacionAccesoUseCase recuperacionUseCase) {
		super();
		this.recuperacionUseCase = recuperacionUseCase;
	}
	
	/** Paso 1: dado el correo, devuelve la pregunta de seguridad. */
	@PostMapping("/pregunta")
	@ResponseStatus(HttpStatus.OK)
	public PreguntaSeguridadResponseDto obtenerPregunta(
			@Valid @RequestBody PreguntaSeguridadRequestDto request) {

		String pregunta = recuperacionUseCase.obtenerPregunta(request.getCorreo());

		PreguntaSeguridadResponseDto response = new PreguntaSeguridadResponseDto();
		response.setCorreo(request.getCorreo());
		response.setPregunta(pregunta);
		return response;
	}

	/** Paso 2: valida la respuesta y fija la contrasena nueva. */
	@PostMapping("/restablecer")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void restablecer(@Valid @RequestBody RestablecerAccesoRequestDto request) {
		recuperacionUseCase.restablecerContrasenia(
				request.getCorreo(), request.getRespuesta(), request.getNuevaContrasenia());
	}

	/** Configuracion inicial o cambio de la pregunta. */
	@PutMapping("/configurar/{idUsuario}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void configurar(@PathVariable int idUsuario,
			@Valid @RequestBody ConfigurarPreguntaRequestDto request) {
		recuperacionUseCase.configurarPregunta(idUsuario, request.getPregunta(), request.getRespuesta());
	}

	/** Permite al cliente saber si hay que pedir la configuracion inicial. */
	@GetMapping("/configurada/{idUsuario}")
	@ResponseStatus(HttpStatus.OK)
	public boolean configurada(@PathVariable int idUsuario) {
		return recuperacionUseCase.tienePreguntaConfigurada(idUsuario);
	}

}
