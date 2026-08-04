package com.prototipo.gestalab.presentacion.controladores;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecuperacionAccesoUseCase;
import com.prototipo.gestalab.presentacion.dto.request.RestablecerConTokenRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.SolicitarRecuperacionRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.SolicitudRecuperacionResponseDto;

import jakarta.validation.Valid;


@RequestMapping("/api/gestalab/recuperacion")
@RestController
public class RecuperacionAccesoController {

	private final IRecuperacionAccesoUseCase recuperacionUseCase;

	@Value("${gestalab.recuperacion.minutos-validez:30}")
	private int minutosValidez;

	public RecuperacionAccesoController(IRecuperacionAccesoUseCase recuperacionUseCase) {
		super();
		this.recuperacionUseCase = recuperacionUseCase;
	}

	/** Paso 1: genera el enlace y lo envia al correo personal. */
	@PostMapping("/solicitar")
	@ResponseStatus(HttpStatus.OK)
	public SolicitudRecuperacionResponseDto solicitar(
			@Valid @RequestBody SolicitarRecuperacionRequestDto request) {

		String enmascarado = recuperacionUseCase.solicitarEnlace(request.getCorreo());

		SolicitudRecuperacionResponseDto response = new SolicitudRecuperacionResponseDto();
		response.setCorreoEnmascarado(enmascarado);
		response.setMinutosValidez(minutosValidez);
		return response;
	}

	/** Paso 2: el cliente comprueba el enlace antes de pintar el formulario. */
	@GetMapping("/validar/{token}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void validar(@PathVariable String token) {
		recuperacionUseCase.validarToken(token);
	}

	/** Paso 3: fija la contrasena nueva y quema el enlace. */
	@PostMapping("/restablecer")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void restablecer(@Valid @RequestBody RestablecerConTokenRequestDto request) {
		recuperacionUseCase.restablecerConToken(request.getToken(), request.getNuevaContrasenia());
	}

}
