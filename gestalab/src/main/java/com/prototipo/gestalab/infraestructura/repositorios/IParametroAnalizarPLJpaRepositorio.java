package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.ParametroAnalizarPLEntity;

public interface IParametroAnalizarPLJpaRepositorio extends JpaRepository<ParametroAnalizarPLEntity, Integer> {
	
	List<ParametroAnalizarPLEntity> findByFkPlanMuestreoEntity_IdPlan(int idPlan);

}
