package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpleadoRequestDto {
	
	@NotBlank
	private int idEmpleado;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String ci;
	@NotBlank
	private String correo;
	@NotBlank
	private String direccion;
	@NotBlank
	private Date fechaIngreso;
	@NotBlank
	private Date fechaSalida;
	@NotBlank
	private boolean estadoEmpleado;

}
