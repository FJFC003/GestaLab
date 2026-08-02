package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquipoLaboratorioRequestDto {
	
	private int idEquipoLab;

	@NotBlank(message = "El nombre del equipo es obligatorio")
	private String nombre;

	private String marca;
	private String modelo;
	private String serie;

	@NotBlank(message = "El código interno es obligatorio")
	private String codigoInterno;

	private boolean estadoEquipoLab;

}
