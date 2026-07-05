package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.EEPPL;

public interface IEEPPLRepositorio {
	
	EEPPL guardar(EEPPL nuevoEEPPL);
	Optional<EEPPL> buscarPorId(int idEEP);
	List<EEPPL> ListarTodos();
	void eliminar(int idEEP);

}
