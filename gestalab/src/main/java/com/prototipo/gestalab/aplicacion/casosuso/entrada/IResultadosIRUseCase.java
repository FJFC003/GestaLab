package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.ResultadosIR;

public interface IResultadosIRUseCase {
	
	ResultadosIR guardar(ResultadosIR nuevo);
	ResultadosIR buscarPorId(int idResultados);
	List<ResultadosIR> ListarTodos();
	void eliminar(int idResultados);
	List<ResultadosIR> listarPorInforme(int idInforme);

}
