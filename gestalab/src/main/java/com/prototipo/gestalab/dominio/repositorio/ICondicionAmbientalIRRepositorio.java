package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;

public interface ICondicionAmbientalIRRepositorio {
	
	CondicionAmbientalIR guardar(CondicionAmbientalIR nuevo);
	Optional<CondicionAmbientalIR> buscarPorId(int idCondi);
	List<CondicionAmbientalIR> ListarTodos();
	void eliminar(int idCondi);
	List<CondicionAmbientalIR> listarPorInforme(int idInforme);

}
