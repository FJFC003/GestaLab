package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.DetalleC;

public interface IDetalleCUseCase {
	
	DetalleC guardar (DetalleC nuevaDetalle);
	DetalleC buscarPorId(int idDetalleC);
	List<DetalleC> ListarTodos();
	
	void eliminar (int idDetalleC);

}
