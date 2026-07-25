package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CatalogoParametroCRequestDto {
	
	private int idParametroC;
	private int fkCondicionParametro;
	@NotBlank
	private String ensayoParametroC;
	@NotBlank
	private String tecnicaParametroC;
	@NotBlank
	private String procedimientoInternoParametroC;
	@NotBlank
	private String normaReferencialParametroC;
	@NotBlank
	private String unidadParametroC;
	@NotBlank
	private String rangoTrabajoParametroC;
}
