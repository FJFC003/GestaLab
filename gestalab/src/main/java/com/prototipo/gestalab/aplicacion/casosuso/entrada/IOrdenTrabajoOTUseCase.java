package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.OrdenTrabajoOT;

public interface IOrdenTrabajoOTUseCase {
	
	OrdenTrabajoOT guardar (OrdenTrabajoOT nuevaOrdenTrabajoOT);
	OrdenTrabajoOT buscarPorId (int idOT);
	List<OrdenTrabajoOT> ListarTodos();
	void eliminar (int idOt);

}
