package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;

public interface IInformeResultadosIRUseCase {
	
	InformeResultadosIR guardar(InformeResultadosIR nuevoInformeResultadosIR);
	InformeResultadosIR buscarPorId(int idInforme);
	List<InformeResultadosIR> ListarTodos();
	void eliminar(int idInforme);

}
