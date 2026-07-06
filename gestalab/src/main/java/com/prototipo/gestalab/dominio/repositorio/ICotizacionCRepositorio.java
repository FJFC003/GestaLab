package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;

public interface ICotizacionCRepositorio {
	
	CotizacionC guardar (CotizacionC nuevoCotizacionC);
	Optional<CotizacionC> buscarPorId(int idCotizacionC);
	List<CotizacionC> ListarTodos();
	
	void eliminar (int idCotizacionC);

}
