package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;

public interface IUsuariohasRolRepositorio {
	
	UsuariohasRol guardar(UsuariohasRol nuevoUsuariohasRol);
	Optional<UsuariohasRol> buscarPorId(int idUsuarioRol);
	List<UsuariohasRol> ListarTodos();
	
	void eliminar(int idUsuarioRol);

}
