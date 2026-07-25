package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DetalleC;

public interface IDetalleCRepositorio {
	
	DetalleC guardar (DetalleC nuevoDetalleC);
	Optional<DetalleC> buscarPorId(int idDetalleC);
	List<DetalleC> ListarTodos();
	List<DetalleC> buscarPorCotizacion(int idCotizacionC);
	
	void eliminar (int idDetalleC);

}
