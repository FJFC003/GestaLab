package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RecursosCronoPLRequestDto {
	
	private int idRecursos;
	@NotNull(message = "La fecha de muestreo es obligatoria")
	private Date fechaMuestreo;

	@Positive(message = "Debe indicar el técnico asignado")
	private int fkTecnico;

	@NotBlank(message = "El recurso es obligatorio")
	private String recurso;

	@NotNull(message = "La hora definida es obligatoria")
	private Date horaDefinida;

}
