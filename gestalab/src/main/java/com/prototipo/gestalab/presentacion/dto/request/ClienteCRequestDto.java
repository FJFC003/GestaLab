package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteCRequestDto {
	
	@NotBlank
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
	private String correoClienteC;
	@NotBlank
	private boolean estadoClienteC;

}
