package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InformacionMatrizPLRequestDto {
	
	private int idInfoMatriz;

	@Positive(message = "El número de ítem debe ser mayor a cero")
	private int noItem;

	// El tipo de matriz lo elige la Coordinadora Tecnica del catalogo al
	// elaborar el plan; al generarlo desde la cotizacion todavia no se conoce.
	private String tipoMatriz;

	@NotBlank(message = "La ubicación es obligatoria")
	private String Ubicacion;

	private String descripcionDelPunto;
	private String Accesibilidad;

	@Positive(message = "Debe pertenecer a un plan de muestreo")
	private int fkPlanMuestreo;


}
