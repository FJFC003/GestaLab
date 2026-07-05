package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.TipoTomaFreHoraPL;

public interface ITipoTomaFreHoraPLRepositorio {
	
	TipoTomaFreHoraPL guardar(TipoTomaFreHoraPL nuevoTipoTomaFreHoraPL);
	Optional<TipoTomaFreHoraPL> buscarPorId(int idTipoFre);
	List<TipoTomaFreHoraPL> ListarTodos();
	void eliminar(int idTipoFre);

}
