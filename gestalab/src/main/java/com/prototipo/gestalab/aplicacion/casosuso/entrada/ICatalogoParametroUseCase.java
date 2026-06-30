package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CatalogoParametroC;

public interface ICatalogoParametroUseCase {
	
	CatalogoParametroC guardar (CatalogoParametroC nuevaCataPara);
	CatalogoParametroC buscarPorId(int idParametroC);
	List<CatalogoParametroC> ListarTodos();
	
	void eliminar (int idParametroC);

}
