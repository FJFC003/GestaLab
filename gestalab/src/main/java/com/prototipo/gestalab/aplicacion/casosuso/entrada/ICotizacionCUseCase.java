package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;

public interface ICotizacionCUseCase {
	
	CotizacionC guardar (CotizacionC nuevaCotizacion);
	CotizacionC buscarPorId(int idCotizacionC);
	List<CotizacionC> ListarTodos();
	
	void eliminar (int idCotizacionC);

}
