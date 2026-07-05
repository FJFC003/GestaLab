package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.PlanMuestreoPL;

public interface IPlanMuestreoPLUseCase {
	
	PlanMuestreoPL guardar(PlanMuestreoPL nuevoPlan);
	PlanMuestreoPL buscarPorId(int idPlan);
	List<PlanMuestreoPL> ListarTodos();
	void eliminar(int idPlan);

}
