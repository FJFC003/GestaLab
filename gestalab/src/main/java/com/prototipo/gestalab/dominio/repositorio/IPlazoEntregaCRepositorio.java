package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.PlazoEntregaC;

public interface IPlazoEntregaCRepositorio {
	
	PlazoEntregaC guardar(PlazoEntregaC nuevo);
	Optional<PlazoEntregaC> buscarPorId(int idPlazoEntregaC);
	List<PlazoEntregaC> ListarTodos();
	void eliminar(int idPlazoEntregaC);

}
