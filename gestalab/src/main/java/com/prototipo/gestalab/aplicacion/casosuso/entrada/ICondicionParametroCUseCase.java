package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CondicionParametroC;

public interface ICondicionParametroCUseCase {
	CondicionParametroC guardar(CondicionParametroC nuevo);
	CondicionParametroC buscarPorId(int idCondicionParametroC);
	List<CondicionParametroC> ListarTodos();
	void eliminar(int idCondicionParametroC);

}
