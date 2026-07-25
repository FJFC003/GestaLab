package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CondicionParametroC;

public interface ICondicionParametroCRepositorio {
	
	CondicionParametroC guardar(CondicionParametroC nuevo);
	Optional<CondicionParametroC> buscarPorId(int idCondicionParametroC);
	List<CondicionParametroC> ListarTodos();
	void eliminar(int idCondicionParametroC);

}
