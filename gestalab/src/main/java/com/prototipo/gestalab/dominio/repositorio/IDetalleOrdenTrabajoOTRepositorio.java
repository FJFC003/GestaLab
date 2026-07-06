package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DetalleOrdenTrabajoOT;

public interface IDetalleOrdenTrabajoOTRepositorio {
	
	DetalleOrdenTrabajoOT guardar (DetalleOrdenTrabajoOT nuevoDetalleOrdenTrabajo);
	Optional<DetalleOrdenTrabajoOT> buscarPorId(int idDetalleOrdenOT);
	List<DetalleOrdenTrabajoOT> ListarTodos();
	
	void eliminar (int idDetalleOrdenOT);

}
