package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class EmpleadoRequestDto {
	
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private String ci;
	@Email(message = "El correo no tiene un formato válido")
	private String correo;
	private String direccion;
	private Date fechaIngreso;
	private Date fechaSalida;
	private boolean estadoEmpleado;
	private int fkArea;
	private int fkCargo;
	private int fkFirmaElectronica;
	private int fkUsuario;

}
