package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.Area;

public interface IAreaUseCase {
	
	Area guardar (Area nuevaArea);
	Area buscarPorId(int idArea);
	List<Area> ListarTodos();
	
	void eliminar (int idArea);

}
