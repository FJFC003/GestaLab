package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.VerificacionPL;

public interface IVerificacionPLRepositorio {
	
	VerificacionPL guardar(VerificacionPL nuevoVerificacionPL);
	Optional<VerificacionPL> buscarPorId(int idVerificacion);
	List<VerificacionPL> ListarTodos();
	void eliminar(int idVerificacion);

}
