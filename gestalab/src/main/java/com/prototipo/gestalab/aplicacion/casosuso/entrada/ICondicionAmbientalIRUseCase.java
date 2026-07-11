package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;

public interface ICondicionAmbientalIRUseCase {
	
	CondicionAmbientalIR guardar(CondicionAmbientalIR nuevoCondicionAmbientalIR);
	CondicionAmbientalIR buscarPorId(int idCondi);
	List<CondicionAmbientalIR> ListarTodos();
	void eliminar(int idCondi);

}
