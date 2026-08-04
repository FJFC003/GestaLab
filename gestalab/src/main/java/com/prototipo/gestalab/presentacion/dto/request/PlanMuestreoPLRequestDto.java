package com.prototipo.gestalab.presentacion.dto.request;

import java.util.Date;

import com.prototipo.gestalab.dominio.entidades.EstadoPlanMuestreo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PlanMuestreoPLRequestDto {
	
	private int idPlan;

	/**
	 * SIN @NotBlank a proposito.
	 *
	 * La identificacion del plan (PM-AAAA-0000) la genera el backend en
	 * PlanMuestreoPLUseCaseImpl.generarCodigoPlan(), y el cliente la envia en
	 * blanco justo para eso. Si se le pone @NotBlank, la validacion se ejecuta
	 * ANTES de entrar al controlador y rechaza la peticion con un 400, sin dar
	 * oportunidad al caso de uso de generar el codigo.
	 *
	 * Cuando el codigo SI viene informado (edicion de un plan existente), el
	 * caso de uso comprueba que no este repetido.
	 */
	private String codigoPlan;

	@NotBlank(message = "El objetivo del plan es obligatorio")
	private String ObjetivoPlan;

	@NotNull(message = "La fecha de elaboración es obligatoria")
	private Date fechaElaboracion;

	@Positive(message = "Debe indicar el responsable del plan")
	private int fkResponsable;

	@Positive(message = "El plan debe nacer de una línea de cotización")
	private int fkDetalleCotizacion;

	private int fkeep;

	private EstadoPlanMuestreo estadoPlan;
	
}
