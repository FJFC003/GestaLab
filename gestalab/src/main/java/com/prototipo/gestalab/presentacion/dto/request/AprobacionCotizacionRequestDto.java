package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AprobacionCotizacionRequestDto {
	
	@NotNull(message = "Debe indicar el empleado que aprueba")
	private Integer fkEmpleadoAprueba;

	@NotNull(message = "Debe indicar la fecha de pago")
	private Date fechaPago;

}
