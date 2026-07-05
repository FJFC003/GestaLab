package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;

public interface IPlanMuestreoPLRepositorio {

	PlanMuestreoPL guardar(PlanMuestreoPL nuevoPlan);
	Optional<PlanMuestreoPL> buscarPorId(int idPlan);
	List<PlanMuestreoPL> ListarTodos();
	void eliminar(int idPlan);
	
}
