package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.DesviosOrdenOT;

public interface IDesviosOrdenOTUseCase {
	
	DesviosOrdenOT guardar (DesviosOrdenOT nuevaDesvioOrdenOT);
	DesviosOrdenOT buscarPorId(int idDesviosOrdenOT);
	List<DesviosOrdenOT> ListarTodos();
	
	void eliminar (int idDesviosOrdenOT);


}
