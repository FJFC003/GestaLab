package com.prototipo.gestalab.presentacion.dto.response;

import lombok.Data;

@Data
public class DetalleParametroCResponseDto {

	private int idDetalleParametroC;
	private CatalogoParametroCResponseDto fkParametro;
	private LmpCResponseDto fkLmp;

}
