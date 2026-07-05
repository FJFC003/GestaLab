package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;

public interface IRecursosCronoPLRepositorio {
	
	RecursosCronoPL guardar(RecursosCronoPL nuevoRecursosCronoPL);
	Optional<RecursosCronoPL> buscarPorId(int idRecursos);
	List<RecursosCronoPL> ListarTodos();
	void eliminar(int idRecursos);

}
