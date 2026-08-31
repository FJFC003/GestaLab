package com.prototipo.gestalab.presentacion.dto.request;

import lombok.Data;

@Data
public class DetalleParametroCRequestDto {

	private int idDetalleParametroC;
	private int fkParametro;
	private int fkLmp;

}
