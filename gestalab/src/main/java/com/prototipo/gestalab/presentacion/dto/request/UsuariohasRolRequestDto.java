package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuariohasRolRequestDto {
	
	@NotBlank
	private int idUsuarioRol;
	@NotBlank
	private Date fechaAsignacion;

}
