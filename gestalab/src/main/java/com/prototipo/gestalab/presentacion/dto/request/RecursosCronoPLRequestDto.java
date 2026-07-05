package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RecursosCronoPLRequestDto {
	@NotBlank
	private int idRecursos;
	@NotBlank
	private Date fechaMuestreo;
	@NotBlank
	private String nombreTecnico;
	@NotBlank
	private String recurso;
	@NotBlank
	private Date horaDefinida;

}
