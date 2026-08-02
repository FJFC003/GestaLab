package com.prototipo.gestalab.presentacion.dto.request;

import lombok.Data;

@Data
public class EquiposUtilizadosIRRequestDto {
	
	private int idEquipos;
	private String nombre;
	private String marca;
	private String modelo;
	private String serie;
	private String codigoInterno;
	private int fkInforme;

}
