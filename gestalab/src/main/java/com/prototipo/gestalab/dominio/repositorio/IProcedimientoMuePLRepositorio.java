package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;

public interface IProcedimientoMuePLRepositorio {
	
	ProcedimientoMuePL guardar(ProcedimientoMuePL nuevoProMue);
	Optional<ProcedimientoMuePL> buscarPorId(int idProcedimiento);
	List<ProcedimientoMuePL> ListarTodos();
	void eliminar(int idProcedimiento);
	

}
