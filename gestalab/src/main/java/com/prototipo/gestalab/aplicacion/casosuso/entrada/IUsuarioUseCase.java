package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.Usuario;

public interface IUsuarioUseCase {
	
	Usuario guardar(Usuario nuevoUsuario);
	Usuario buscarPorId(int idUsuario);
	List<Usuario> ListarTodos();
	
	void eliminar(int idUsuario);

}
