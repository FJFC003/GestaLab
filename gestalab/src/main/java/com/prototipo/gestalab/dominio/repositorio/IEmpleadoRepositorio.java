package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Empleado;

public interface IEmpleadoRepositorio {
	
	Empleado guardar(Empleado nuevoEmpleado);
	Optional<Empleado> buscarPorId(int idEmpleado);
	List<Empleado> ListarTodo();
	
	void eliminar(int idEmpleado);

}
