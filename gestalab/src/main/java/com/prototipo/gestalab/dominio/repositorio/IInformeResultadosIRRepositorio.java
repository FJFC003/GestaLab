package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;

public interface IInformeResultadosIRRepositorio {
	
	InformeResultadosIR guardar(InformeResultadosIR nuevoInforme);
	Optional<InformeResultadosIR> buscarPorId(int idInforme);
	List<InformeResultadosIR> ListarTodos();
	void eliminar(int idInforme);
	Optional<InformeResultadosIR> buscarPorOrden(int idOT);

}
