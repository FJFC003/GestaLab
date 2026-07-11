package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;

public interface IEquiposUtilizadosIRRepositorio {
	
	EquiposUtilizadosIR guardar(EquiposUtilizadosIR nuevoEquiposUtilizadosIR);
	Optional<EquiposUtilizadosIR> buscarPorId(int idEquipos);
	List<EquiposUtilizadosIR> ListarTodos();
	void eliminar(int idEquipos);

}
