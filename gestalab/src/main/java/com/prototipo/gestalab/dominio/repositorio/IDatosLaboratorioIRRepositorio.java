package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DatosLaboratorioIR;

public interface IDatosLaboratorioIRRepositorio {
	
	DatosLaboratorioIR guardar(DatosLaboratorioIR nuevoDatosLaboratorioIR);
	Optional<DatosLaboratorioIR> buscarPorId(int idDatos);
	List<DatosLaboratorioIR> ListarTodos();
	void eliminar(int idDatos);

}
