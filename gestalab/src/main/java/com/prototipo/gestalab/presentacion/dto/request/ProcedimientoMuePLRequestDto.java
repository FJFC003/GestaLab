package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProcedimientoMuePLRequestDto {
	
	private int idProcedimiento;

	@Positive(message = "El número de ítem debe ser mayor a cero")
	private int noItem;

	@NotBlank(message = "El tipo de matriz es obligatorio")
	private String Tipo;

	private String descripcion;

	@NotBlank(message = "Las precauciones son obligatorias")
	private String precausiones;

	@Positive(message = "Debe pertenecer a un plan de muestreo")
	private int fkPlanMuestreo;



}
