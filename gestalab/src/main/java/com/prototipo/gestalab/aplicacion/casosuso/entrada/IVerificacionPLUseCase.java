package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.VerificacionPL;

public interface IVerificacionPLUseCase {
	
	VerificacionPL guardar(VerificacionPL nuevoVerificacionPL);
	VerificacionPL buscarPorId(int idVerificacion);
	List<VerificacionPL> ListarTodos();
	void eliminar(int idVerificacion);

}
