package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DescripcionServicioC;

public interface IDescripcionServicioCRepositorio {
	
	DescripcionServicioC guardar(DescripcionServicioC nuevo);
	Optional<DescripcionServicioC> buscarPorId(int idDescripcionServicioC);
	List<DescripcionServicioC> ListarTodos();
	void eliminar(int idDescripcionServicioC);

}
