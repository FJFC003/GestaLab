package com.prototipo.gestalab.presentacion.dto.response;

import java.util.Date;

import lombok.Data;
@Data
public class UsuariohasRolResponseDto {
	
	private int idUsuarioRol;
	private Date fechaAsignacion;
	private UsuarioResponseDto fkUsuario;
	private RolResponseDto fkRol;

}
