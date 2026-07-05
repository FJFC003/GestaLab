package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.EEPPL;

public interface IEEPPLUseCase {
	
	EEPPL guardar(EEPPL nuevoEEPPL);
	EEPPL buscarPorId(int idEEP);
	List<EEPPL> ListarTodos();
	void eliminar(int idEEP);

}
