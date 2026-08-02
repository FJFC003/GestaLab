package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.EquipoLaboratorio;

public interface IEquipoLaboratorioRepositorio {
	
	EquipoLaboratorio guardar(EquipoLaboratorio nuevoEquipoLaboratorio);
	Optional<EquipoLaboratorio> buscarPorId(int idEquipoLab);
	List<EquipoLaboratorio> ListarTodos();
	void eliminar(int idEquipoLab);

}
