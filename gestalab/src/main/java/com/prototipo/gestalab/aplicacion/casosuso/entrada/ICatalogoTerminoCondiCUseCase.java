package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CatalogoTerminoCondiC;

public interface ICatalogoTerminoCondiCUseCase {
	
	CatalogoTerminoCondiC guardar (CatalogoTerminoCondiC nuevaTerminoCondi);
	CatalogoTerminoCondiC buscarPorId(int idTerminoC);
	List<CatalogoTerminoCondiC> ListarTodos();
	
	void eliminar(int idTerminoC);

}
