package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;

public interface IUsuariohasRolUseCase {
	
	UsuariohasRol guardar(UsuariohasRol nuevoUsuariohasRol);
	UsuariohasRol buscarPorId(int idUsuarioRol);
	List<UsuariohasRol> ListarTodos();
	
	void eliminar(int idUsuarioRol);

}
