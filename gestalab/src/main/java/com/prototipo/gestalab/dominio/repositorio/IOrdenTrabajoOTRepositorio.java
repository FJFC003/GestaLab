package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;

public interface IOrdenTrabajoOTRepositorio {
	
	OrdenTrabajoOT guardar (OrdenTrabajoOT nuevaOrdenTrabajoOT);
	Optional<OrdenTrabajoOT> buscarPorId (int idOT);
	List<OrdenTrabajoOT> ListarTodos();
	void eliminar (int idOt);

}
