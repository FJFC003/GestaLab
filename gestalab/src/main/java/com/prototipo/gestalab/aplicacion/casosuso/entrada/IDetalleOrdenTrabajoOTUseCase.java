package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.DetalleOrdenTrabajoOT;

public interface IDetalleOrdenTrabajoOTUseCase {
	
	DetalleOrdenTrabajoOT guardar (DetalleOrdenTrabajoOT nuevaDesvioOrdenOT);
	DetalleOrdenTrabajoOT buscarPorId(int idDetalleOrdenOT);
	List<DetalleOrdenTrabajoOT> ListarTodos();
	
	void eliminar (int idDetalleOrdenOT);


}
