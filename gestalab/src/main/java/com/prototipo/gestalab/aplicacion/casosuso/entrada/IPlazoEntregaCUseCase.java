package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.PlazoEntregaC;

public interface IPlazoEntregaCUseCase {
	
	PlazoEntregaC guardar(PlazoEntregaC nuevo);
	PlazoEntregaC buscarPorId(int idPlazoEntregaC);
	List<PlazoEntregaC> ListarTodos();
	void eliminar(int idPlazoEntregaC);

}
