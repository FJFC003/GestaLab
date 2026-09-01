package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CatalogoPlanPLRequestDto {

	private int idCatalogoPlanPL;
	@NotBlank
	private String tipoLista;
	@NotBlank
	private String valorCatalogoPlanPL;
	private String descripcionCatalogoPlanPL;
	private int ordenCatalogoPlanPL;
	private boolean estadoCatalogoPlanPL;

}
