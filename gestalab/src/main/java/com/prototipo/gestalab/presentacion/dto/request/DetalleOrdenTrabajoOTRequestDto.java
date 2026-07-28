package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DetalleOrdenTrabajoOTRequestDto {
	
	private int idDetalleOrdenOT;

	@Positive(message = "El número de ítem debe ser mayor a cero")
	private int noItemDetalleOrdenOT;

	@NotBlank(message = "La descripción de la actividad es obligatoria")
	private String descripcionActividadDetalleOrdenOT;

	@NotNull(message = "La fecha planificada es obligatoria")
	private Date fechaPlanificadaDetalleOrdenOT;

	@Positive(message = "Los puntos planificados deben ser mayores a cero")
	private int puntosPlanificadosDetalleOrdenOT;

	// Lo escribe la Coordinacion Tecnica al cerrar: puede llegar en 0
	private int puntosEjecutadosDetalleOrdenOT;

	@Positive(message = "Debe pertenecer a una orden de trabajo")
	private int fkOrdenTrabajo;


}
