package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.NormaParametroLmpC;

public interface INormaParametroLmpCUseCase {
	
	NormaParametroLmpC guardar(NormaParametroLmpC nuevo);
	NormaParametroLmpC buscarPorId(int idNormaParametroLmpC);
	List<NormaParametroLmpC> ListarTodos();
	List<NormaParametroLmpC> buscarPorNorma(int idCatalogoNormServi);
	void eliminar(int idNormaParametroLmpC);


}
