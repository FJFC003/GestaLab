package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.LmpC;

public interface ILmpCRepositorio {
	
	LmpC guardar(LmpC nuevo);
	Optional<LmpC> buscarPorId(int idLmpC);
	List<LmpC> ListarTodos();
	void eliminar(int idLmpC);

}
