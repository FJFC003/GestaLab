package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.InformacionMatrizPL;

public interface IInformacionMatrizPLUseCase {
	
	InformacionMatrizPL guardar(InformacionMatrizPL nuevoInfoMatriz);
	InformacionMatrizPL buscarPorId(int idInfoMatriz);
	List<InformacionMatrizPL> ListarTodos();
	void eliminar(int idInfoMatriz);

}
