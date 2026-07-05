package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.InformacionAdicionalPL;

public interface IInformacionAdicionalPLRepositorio {
	
	InformacionAdicionalPL guardar(InformacionAdicionalPL nuevoInfoAdi);
	Optional<InformacionAdicionalPL> buscarPorId(int idInformacion);
	List<InformacionAdicionalPL> ListarTodos();
	void eliminar(int idInformacion);

}
