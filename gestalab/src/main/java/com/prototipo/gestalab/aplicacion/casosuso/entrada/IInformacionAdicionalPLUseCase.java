package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;

public interface IInformacionAdicionalPLUseCase {
	
	InformacionAdicionalPL guardar(InformacionAdicionalPL nuevoInfoAdi);
	InformacionAdicionalPL buscarPorId(int idInformacion);
	List<InformacionAdicionalPL> ListarTodos();
	void eliminar(int idInformacion);

}
