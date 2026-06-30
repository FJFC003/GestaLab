package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CatalogoNormServiC;

public interface ICatalogoNormServiCUseCase {
	
	CatalogoNormServiC guardar (CatalogoNormServiC nuevoCargo);
	CatalogoNormServiC buscarPorId(int idCatalogoNormServi);
	List<CatalogoNormServiC> ListarTodos();
	
	void eliminar (int idCatalogoNormServi);

}
