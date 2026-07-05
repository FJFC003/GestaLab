package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlanMuestreoPLRequestDto {
	
	@NotBlank
	private int idPlan;
	@NotBlank
	private String ObjetivoPlan;

}
