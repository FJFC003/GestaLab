package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.DetalleC;

public interface IDetalleCUseCase {
	
	DetalleC guardar (DetalleC nuevaDetalle);
	DetalleC buscarPorId(int idDetalleC);
	List<DetalleC> ListarTodos();
	List<DetalleC> buscarPorCotizacion(int idCotizacionC);
	
	void eliminar (int idDetalleC);

}
