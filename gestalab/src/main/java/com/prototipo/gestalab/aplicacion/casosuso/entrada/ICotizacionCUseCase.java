package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.Date;
import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;

public interface ICotizacionCUseCase {
	
	CotizacionC guardar (CotizacionC nuevaCotizacion);
	CotizacionC buscarPorId(int idCotizacionC);
	List<CotizacionC> ListarTodos();
	
	CotizacionC aprobar(int idCotizacionC, int idEmpleadoAprueba, Date fechaPago);
	CotizacionC rechazar(int idCotizacionC);
	
	void eliminar (int idCotizacionC);

}
