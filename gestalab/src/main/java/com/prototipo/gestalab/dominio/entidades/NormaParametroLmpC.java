package com.prototipo.gestalab.dominio.entidades;

import lombok.Data;

@Data
public class NormaParametroLmpC {
	
	private int idNormaParametroLmpC;
	private CatalogoNormServiC fkNorma;
	private CatalogoParametroC fkParametro;
	private LmpC fkLmp;

}
