package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.Usuario;

public interface IUsuarioRepositorio {
	
	Usuario guardar(Usuario nuevoUsuario);
	Optional<Usuario> buscarPorId(int idUsuario);
	List<Usuario> ListarTodos();
	
	Optional<Usuario> buscarPorCorreo(String correo);
	
	void eliminar(int idUsuario);

}
