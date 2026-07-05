package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.ParametroAnalizarPL;

public interface IParametroAnalizarPLRepositorio {
	
	ParametroAnalizarPL guardar(ParametroAnalizarPL nuevoParameAnali);
	Optional<ParametroAnalizarPL> buscarPorId(int idParametroPL);
	List<ParametroAnalizarPL> ListarTodos();
	void eliminar(int idParametroPL);

}
