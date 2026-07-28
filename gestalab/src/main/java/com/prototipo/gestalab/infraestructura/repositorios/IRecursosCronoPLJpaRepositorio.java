package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.RecursosCronoPLEntity;

public interface IRecursosCronoPLJpaRepositorio extends JpaRepository<RecursosCronoPLEntity, Integer>{
	
	List<RecursosCronoPLEntity> findByFkPlanMuestreoEntity_IdPlan(int idPlan);
	
	List<RecursosCronoPLEntity> findByFkTecnicoEntity_IdEmpleado(int idEmpleado);

}
