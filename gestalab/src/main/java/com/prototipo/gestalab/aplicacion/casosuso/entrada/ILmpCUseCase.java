package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.LmpC;

public interface ILmpCUseCase {
	
	LmpC guardar(LmpC nuevo);
	LmpC buscarPorId(int idLmpC);
	List<LmpC> ListarTodos();
	void eliminar(int idLmpC);

}
