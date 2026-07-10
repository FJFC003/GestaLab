package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FirmaElectronicaRequestDto {
	@NotBlank
	private int idFirma;
	@NotBlank
	private String formatoFirma;
	@NotBlank
	private Date fechaSubida;
	@NotBlank
	private Date fechaExpiracion;

}
