package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class VerificacionPLRequestDto {
	
	private int idVerificacion;
	@Positive(message = "El número de ítem debe ser mayor a cero")
	private int noItem;
	private boolean tipoMatrizDeclarada;
	private boolean frecuanciaDeclarada;
	private boolean sitiosDeclarados;
	@Positive(message = "Debe pertenecer a un plan de muestreo")
	private int fkPlanMuestreo;

}
