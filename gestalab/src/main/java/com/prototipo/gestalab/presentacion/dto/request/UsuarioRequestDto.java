package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequestDto {
	
	@NotBlank
	private int idUsuario;
	@NotBlank
	private String nombre;
	@NotBlank
	private String correo;
	@NotBlank
	private String contrasenia;
	@NotBlank
	private Date fechaCreacion;
	@NotBlank
	private boolean estadoUsuario;

}
