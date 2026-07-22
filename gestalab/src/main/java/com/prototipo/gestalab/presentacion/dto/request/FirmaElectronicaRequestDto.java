package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FirmaElectronicaRequestDto {
	private int idFirma;
	@NotBlank
	private String formatoFirma;
	private Date fechaSubida;
	private Date fechaExpiracion;

}
