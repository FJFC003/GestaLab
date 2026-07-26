package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.DescripcionServicioC;

public interface IDescripcionServicioCUseCase {
	
	DescripcionServicioC guardar(DescripcionServicioC nuevo);
	DescripcionServicioC buscarPorId(int idDescripcionServicioC);
	List<DescripcionServicioC> ListarTodos();
	void eliminar(int idDescripcionServicioC);

}
