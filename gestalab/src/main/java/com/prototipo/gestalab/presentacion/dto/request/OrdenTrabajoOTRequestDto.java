package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrdenTrabajoOTRequestDto {
	
	@NotBlank
	private int idOT;
	@NotBlank
	private int noItemOT;
	@NotBlank
	private Date fechaEmisionOT;
	@NotBlank
	private String responsableEmsionOT;
	@NotBlank
	private String tecnicoLaboratorioOT;
	@NotBlank
	private String nombrePersonaContactoOT;
	@NotBlank
	private Date fechaCierreCampoOT;

}
