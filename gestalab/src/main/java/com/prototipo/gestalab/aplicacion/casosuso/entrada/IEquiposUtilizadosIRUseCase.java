package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;

public interface IEquiposUtilizadosIRUseCase {
	
	EquiposUtilizadosIR guardar(EquiposUtilizadosIR nuevoEquiposUtilizadosIR);
	EquiposUtilizadosIR buscarPorId(int idEquipos);
	List<EquiposUtilizadosIR> ListarTodos();
	void eliminar(int idEquipos);

}
