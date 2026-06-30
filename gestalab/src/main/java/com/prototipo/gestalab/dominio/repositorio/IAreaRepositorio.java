package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Area;

public interface IAreaRepositorio {
	
	Area guardar (Area nuevaArea);
	Optional<Area> buscarPorId(int idArea);
	List<Area> ListarTodos();
	
	void eliminar (int idArea);

}
