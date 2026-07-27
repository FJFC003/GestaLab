package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PlanMuestreoPLRequestDto {
	
	private int idPlan;

	@NotBlank(message = "El código del plan es obligatorio")
	private String codigoPlan;

	@NotBlank(message = "El objetivo del plan es obligatorio")
	private String ObjetivoPlan;

	@NotNull(message = "La fecha de elaboración es obligatoria")
	private Date fechaElaboracion;

	@Positive(message = "Debe indicar el responsable del plan")
	private int fkResponsable;

	@Positive(message = "El plan debe nacer de una línea de cotización")
	private int fkDetalleCotizacion;

}
