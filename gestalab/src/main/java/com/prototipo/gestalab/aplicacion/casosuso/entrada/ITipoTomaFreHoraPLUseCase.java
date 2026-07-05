package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;

public interface ITipoTomaFreHoraPLUseCase {
	
	TipoTomaFreHoraPL guardar(TipoTomaFreHoraPL nuevoTipoTomaFreHoraPL);
	TipoTomaFreHoraPL buscarPorId(int idTipoFre);
	List<TipoTomaFreHoraPL> ListarTodos();
	void eliminar(int idTipoFre);

}
