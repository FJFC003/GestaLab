package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.TipoTomaMuestraC;

public interface ITipoTomaMuestraCRepositorio {

	TipoTomaMuestraC guardar(TipoTomaMuestraC nuevo);
	Optional<TipoTomaMuestraC> buscarPorId(int idTipoTomaMuestraC);
	List<TipoTomaMuestraC> ListarTodos();
	void eliminar(int idTipoTomaMuestraC);

}
