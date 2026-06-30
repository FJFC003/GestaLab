package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Cargo;

public interface ICargoRepositorio {
	
	Cargo guardar (Cargo nuevoCargo);
	Optional<Cargo> buscarPorId(int idCargo);
	List<Cargo> ListarTodos();
	
	void eliminar (int idCargo);

}
