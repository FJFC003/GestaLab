package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProcedimientoMuePLRequestDto {
	
	@NotBlank
	private int idProcedimiento;
	@NotBlank
	private int noItem;
	@NotBlank
	private String Tipo;
	@NotBlank
	private String descripcion;
	@NotBlank
	private String precausiones;

}
