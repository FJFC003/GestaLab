package com.prototipo.gestalab.presentacion.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ParametroAnalizarPLRequestDto {
	
	private int idParametroPL;
	@Positive(message = "El número de parámetro debe ser mayor a cero")
	private int noParametroPL;
	@NotBlank(message = "El parámetro es obligatorio")
	private String Parametros;
	@Positive(message = "Debe pertenecer a un plan de muestreo")
	private int fkPlanMuestreo;

}
