package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetalleOrdenTrabajoOTRequestDto {
	
	@NotBlank
	private int idDetalleOrdenOT;
	@NotBlank
	private Date fechaPlanificadaDetalleOrdenOT;
	@NotBlank
	private int puntosPlanificadosDetalleOrdenOT;
	@NotBlank
	private int puntosEjecutadosDetalleOrdenOT;


}
