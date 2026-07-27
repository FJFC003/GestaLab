package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InformacionMatrizPLRequestDto {
	
	private int idInfoMatriz;

	@Positive(message = "El número de ítem debe ser mayor a cero")
	private int noItem;

	@NotBlank(message = "El tipo de matriz es obligatorio")
	private String tipoMatriz;

	@NotBlank(message = "La ubicación es obligatoria")
	private String Ubicacion;

	@NotBlank(message = "La descripción del punto es obligatoria")
	private String descripcionDelPunto;

	@NotBlank(message = "La accesibilidad es obligatoria")
	private String Accesibilidad;

	@Positive(message = "La matriz debe pertenecer a un plan de muestreo")
	private int fkPlanMuestreo;

}
