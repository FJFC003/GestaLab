package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.TipoTomaMuestraC;

public interface ITipoTomaMuestraCUseCase {

	TipoTomaMuestraC guardar(TipoTomaMuestraC nuevo);
	TipoTomaMuestraC buscarPorId(int idTipoTomaMuestraC);
	List<TipoTomaMuestraC> ListarTodos();
	void eliminar(int idTipoTomaMuestraC);

}
