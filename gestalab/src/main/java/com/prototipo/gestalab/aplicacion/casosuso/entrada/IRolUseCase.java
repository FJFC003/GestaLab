package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.Rol;

public interface IRolUseCase {
	
	Rol guardar(Rol nuevoRol);
	Rol buscarPorId(int idRol);
	List<Rol> ListarTodos();
	
	void eliminar(int idRol);

}
