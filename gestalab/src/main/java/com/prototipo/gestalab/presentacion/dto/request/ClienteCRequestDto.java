package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteCRequestDto {
	
	private int idClienteC;
	@NotBlank
	private String tipoClienteC;
	@NotBlank
	private String ciClienteC;
	@NotBlank
	private String nombreRazonSocialClienteC; //persona juridica (nombre de la empresa), persona natural (nombre completo)
	@NotBlank
	private String nombrePersonaContactoClienteC;
	@NotBlank
	private String direccionClienteC;
	@NotBlank
	private String telefonoClienteC;
	@NotBlank
	@Email(message = "El correo no tiene un formato válido")
	private String correoClienteC;
	private boolean estadoClienteC;
	
	

}
