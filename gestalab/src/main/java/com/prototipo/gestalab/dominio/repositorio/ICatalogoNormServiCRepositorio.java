package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoNormServiC;


public interface ICatalogoNormServiCRepositorio {
	
	CatalogoNormServiC guardar (CatalogoNormServiC nuevoCatalogoNorm);
	Optional<CatalogoNormServiC> buscarPorId(int idCatalogoNormServi);
	List<CatalogoNormServiC> ListarTodos();
	
	void eliminar (int idCatalogoNormServi);

}
