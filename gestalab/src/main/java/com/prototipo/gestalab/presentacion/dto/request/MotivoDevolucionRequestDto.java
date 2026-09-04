package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Justificacion con la que la Coordinacion Tecnica devuelve un informe al
 * laboratorio. Va en el cuerpo de la peticion porque un motivo puede ser largo
 * y no tiene por que viajar en la URL.
 */
@Data
public class MotivoDevolucionRequestDto {

	@NotBlank(message = "Debe indicar por qué se devuelve el informe")
	private String motivoDevolucion;

}
