package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TipoTomaFreHoraPLRequestDto {
	
	private int idTipoFre;

	@Positive(message = "El número de ítem debe ser mayor a cero")
	private int noItem;

	@NotBlank(message = "La frecuencia es obligatoria")
	private String frecuencia;

	@NotBlank(message = "El tipo de toma de muestra es obligatorio")
	private String tipo;

	@NotBlank(message = "Las alícuotas son obligatorias")
	private String alicuotas;

	@Positive(message = "Debe pertenecer a un plan de muestreo")
	private int fkPlanMuestreo;

}
