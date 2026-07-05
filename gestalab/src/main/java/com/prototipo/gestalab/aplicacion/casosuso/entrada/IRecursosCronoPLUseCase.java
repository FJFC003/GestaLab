package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.RecursosCronoPL;

public interface IRecursosCronoPLUseCase {
	
	RecursosCronoPL guardar(RecursosCronoPL nuevoRecursosCronoPL);
	RecursosCronoPL buscarPorId(int idRecursos);
	List<RecursosCronoPL> ListarTodos();
	void eliminar(int idRecursos);

}
