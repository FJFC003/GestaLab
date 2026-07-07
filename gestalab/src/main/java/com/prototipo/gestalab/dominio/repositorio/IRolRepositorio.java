package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Rol;

public interface IRolRepositorio {
	
	Rol guardar(Rol nuevoRol);
	Optional<Rol> buscarPorId(int idRol);
	List<Rol> ListarTodos();
	
	void eliminar(int idRol);

}
