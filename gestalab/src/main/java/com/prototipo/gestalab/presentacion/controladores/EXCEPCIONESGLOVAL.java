package com.prototipo.gestalab.presentacion.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EXCEPCIONESGLOVAL {
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<String> handleDuplicado(IllegalStateException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleGenerico(RuntimeException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}

}
