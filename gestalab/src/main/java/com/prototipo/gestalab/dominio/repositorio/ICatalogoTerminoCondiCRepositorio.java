package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CatalogoTerminoCondiC;


public interface ICatalogoTerminoCondiCRepositorio {
	
	CatalogoTerminoCondiC guardar (CatalogoTerminoCondiC nuevaTerminoCondi);
	Optional<CatalogoTerminoCondiC> buscarPorId(int idTerminoC);
	List<CatalogoTerminoCondiC> ListarTodos();
	
	void eliminar (int idTerminoC);

}
