package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.Cargo;

public interface ICargoUseCase {
	
	Cargo guardar (Cargo nuevoCargo);
	Cargo buscarPorId(int idCargo);
	List<Cargo> ListarTodos();
	
	void eliminar (int idCargo);

}
