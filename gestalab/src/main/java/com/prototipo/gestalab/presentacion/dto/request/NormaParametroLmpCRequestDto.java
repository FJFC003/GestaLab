package com.prototipo.gestalab.presentacion.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class NormaParametroLmpCRequestDto {
	
	private int idNormaParametroLmpC;
	@Min(value = 1, message = "Debe seleccionar una norma")
	private int fkNorma;
	@Min(value = 1, message = "Debe seleccionar un parámetro")
	private int fkParametro;
	@Min(value = 1, message = "Debe seleccionar un LMP")
	private int fkLmp;

}
