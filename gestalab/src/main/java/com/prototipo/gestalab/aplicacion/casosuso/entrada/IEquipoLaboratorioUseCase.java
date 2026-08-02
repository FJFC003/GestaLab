package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.EquipoLaboratorio;

public interface IEquipoLaboratorioUseCase {
	
	EquipoLaboratorio guardar(EquipoLaboratorio nuevoEquipoLaboratorio);
	EquipoLaboratorio buscarPorId(int idEquipoLab);
	List<EquipoLaboratorio> ListarTodos();
	List<EquipoLaboratorio> listarActivos();
	void eliminar(int idEquipoLab);

}
