package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoPlanPL;

public interface ICatalogoPlanPLRepositorio {

	CatalogoPlanPL guardar(CatalogoPlanPL nuevo);
	Optional<CatalogoPlanPL> buscarPorId(int idCatalogoPlanPL);
	List<CatalogoPlanPL> ListarTodos();
	List<CatalogoPlanPL> ListarPorTipo(String tipoLista);
	void eliminar(int idCatalogoPlanPL);

}
