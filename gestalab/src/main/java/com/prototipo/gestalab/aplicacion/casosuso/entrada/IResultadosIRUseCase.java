package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.ResultadosIR;

public interface IResultadosIRUseCase {
	
	ResultadosIR guardar(ResultadosIR nuevoResultadosIR);
	ResultadosIR buscarPorId(int idResultados);
	List<ResultadosIR> ListarTodos();
	void eliminar(int idResultados);

}
