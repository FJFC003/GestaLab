package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.ProcedimientoMuePL;

public interface IProcedimientoMuePLUseCase {
	
	ProcedimientoMuePL guardar(ProcedimientoMuePL nuevoProMue);
	ProcedimientoMuePL buscarPorId(int idProcedimiento);
	List<ProcedimientoMuePL> ListarTodos();
	void eliminar(int idProcedimiento);

}
