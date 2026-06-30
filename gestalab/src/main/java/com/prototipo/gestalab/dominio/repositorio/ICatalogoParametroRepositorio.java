package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;


public interface ICatalogoParametroRepositorio {
	
	CatalogoParametroC guardar (CatalogoParametroC nuevaCataPara);
	Optional<CatalogoParametroC> buscarPorId(int idParametroC);
	List<CatalogoParametroC> ListarTodos();
	
	void eliminar (int idParametroC);

}
