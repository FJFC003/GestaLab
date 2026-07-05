package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;

public interface IParametroAnalizarPLUseCase {
	
	ParametroAnalizarPL guardar(ParametroAnalizarPL nuevoParameAnali);
	ParametroAnalizarPL buscarPorId(int idParametroPL);
	List<ParametroAnalizarPL> ListarTodos();
	void eliminar(int idParametroPL);

}
