package com.prototipo.gestalab.presentacion.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CatalogoNormServiCResponseDto {
	
	private int idCatalogoNormServi;
	private String nombreCatalogoNormServiEntity;
	private List<NormaParametroLmpCResponseDto> paresParametroLmp = new ArrayList<>();

}
