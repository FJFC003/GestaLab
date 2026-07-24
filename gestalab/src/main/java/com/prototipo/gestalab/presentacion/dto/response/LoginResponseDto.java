package com.prototipo.gestalab.presentacion.dto.response;

import lombok.Data;

@Data
public class LoginResponseDto {
	
	private int idUsuario;
	private String nombre;
	private String correo;
	private String rol;

}
