package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.Empleado;

public interface IEmpleadoUseCase {
	
	Empleado guardar(Empleado nuevoEmpleado);
	Empleado buscarPorId(int idEmpleado);
	List<Empleado> ListarTodo();
	
	void eliminar(int idEmpleado);

}
