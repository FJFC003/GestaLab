package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrdenTrabajoOTRequestDto {
	
	private int idOT;
	@Positive(message = "El número de ítem debe ser mayor a cero")
	private int noItemOT;

	@NotNull(message = "La fecha de emisión es obligatoria")
	private Date fechaEmisionOT;

	@Positive(message = "Debe indicar el responsable de emisión")
	private int fkResponsableEmision;

	@Positive(message = "Debe indicar el técnico asignado")
	private int fkTecnicoAsignado;

	@NotBlank(message = "El nombre de la persona de contacto es obligatorio")
	private String nombrePersonaContactoOT;

	private Date fechaCierreCampoOT;

	@Positive(message = "La orden debe pertenecer a un plan de muestreo")
	private int fkPlanMuestreo;

}
