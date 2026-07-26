package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.NormaParametroLmpC;

public interface INormaParametroLmpCRepositorio {
	
	NormaParametroLmpC guardar(NormaParametroLmpC nuevo);
	Optional<NormaParametroLmpC> buscarPorId(int idNormaParametroLmpC);
	List<NormaParametroLmpC> ListarTodos();
	List<NormaParametroLmpC> buscarPorNorma(int idCatalogoNormServi);
	void eliminar(int idNormaParametroLmpC);

}
