package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CatalogoPlanPL;

public interface ICatalogoPlanPLUseCase {

	CatalogoPlanPL guardar(CatalogoPlanPL nuevo);
	CatalogoPlanPL buscarPorId(int idCatalogoPlanPL);
	List<CatalogoPlanPL> ListarTodos();
	List<CatalogoPlanPL> ListarPorTipo(String tipoLista);
	void eliminar(int idCatalogoPlanPL);

}
