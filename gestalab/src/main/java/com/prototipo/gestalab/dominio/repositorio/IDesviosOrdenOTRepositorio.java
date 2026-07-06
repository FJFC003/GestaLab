package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DesviosOrdenOT;

public interface IDesviosOrdenOTRepositorio {
	
	DesviosOrdenOT guardar (DesviosOrdenOT nuevoDesviosOrdenOT);
	Optional<DesviosOrdenOT> buscarPorId(int idDesviosOrdenOT);
	List<DesviosOrdenOT> ListarTodos();
	
	void eliminar (int idDesviosOrdenOT);

}
