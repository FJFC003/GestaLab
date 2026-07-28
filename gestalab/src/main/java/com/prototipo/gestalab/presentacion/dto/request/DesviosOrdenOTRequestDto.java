package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DesviosOrdenOTRequestDto {
	
	private int idDesviosOrdenOT;

	@Positive(message = "El número de ítem debe ser mayor a cero")
	private int noItemDesviosOrdenOT;

	@NotBlank(message = "La descripción del desvío es obligatoria")
	private String descripcionDesviosOrdenOT;

	// Puede ser negativo (puntos disminuidos) o cero
	private int puntosModificadosDesviosOrdenOT;

	@Positive(message = "Debe pertenecer a una orden de trabajo")
	private int fkOrdenTrabajo;

}
