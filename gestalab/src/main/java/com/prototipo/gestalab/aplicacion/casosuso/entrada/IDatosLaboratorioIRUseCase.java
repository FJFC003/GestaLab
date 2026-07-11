package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.DatosLaboratorioIR;

public interface IDatosLaboratorioIRUseCase {
	
	DatosLaboratorioIR guardar(DatosLaboratorioIR nuevoDatosLaboratorioIR);
	DatosLaboratorioIR buscarPorId(int idDatos);
	List<DatosLaboratorioIR> ListarTodos();
	void eliminar(int idDatos);

}
