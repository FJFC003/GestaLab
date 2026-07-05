package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;

public interface IInformacionMatrizPLRepositorio {
	
	InformacionMatrizPL guardar(InformacionMatrizPL nuevoInfoMatriz);
	Optional<InformacionMatrizPL> buscarPorId(int idInfoMatriz);
	List<InformacionMatrizPL> ListarTodos();
	void eliminar(int idInfoMatriz);

}
