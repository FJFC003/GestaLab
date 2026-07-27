package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.TipoTomaFreHoraPLEntity;

public interface ITipoTomaFreHoraPLJpaRepositorio extends JpaRepository<TipoTomaFreHoraPLEntity, Integer>{
	
	List<TipoTomaFreHoraPLEntity> findByFkPlanMuestreoEntity_IdPlan(int idPlan);

}
