package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.OrdenTrabajoOTEntity;

public interface IOrdenTrabajoOTJpaRepositorio extends JpaRepository<OrdenTrabajoOTEntity, Integer>{
	
	List<OrdenTrabajoOTEntity> findByFkTecnicoAsignadoEntity_IdEmpleado(int idEmpleado);

	List<OrdenTrabajoOTEntity> findByFkPlanMuestreoEntity_IdPlan(int idPlan);

}
