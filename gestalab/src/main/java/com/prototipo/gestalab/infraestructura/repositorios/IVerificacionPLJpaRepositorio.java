package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.VerificacionPLEntity;

public interface IVerificacionPLJpaRepositorio extends JpaRepository<VerificacionPLEntity, Integer>{
	
	List<VerificacionPLEntity> findByFkPlanMuestreoEntity_IdPlan(int idPlan);

}
