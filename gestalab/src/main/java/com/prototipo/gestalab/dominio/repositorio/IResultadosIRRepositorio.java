package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.ResultadosIR;

public interface IResultadosIRRepositorio {
	
	ResultadosIR guardar(ResultadosIR nuevoResultadosIR);
	Optional<ResultadosIR> buscarPorId(int idResultados);
	List<ResultadosIR> ListarTodos();
	void eliminar(int idResultados);

}
