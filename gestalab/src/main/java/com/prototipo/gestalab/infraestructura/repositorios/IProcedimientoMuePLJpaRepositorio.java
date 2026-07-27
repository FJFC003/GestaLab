package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.ProcedimientoMuePLEntity;

public interface IProcedimientoMuePLJpaRepositorio extends JpaRepository<ProcedimientoMuePLEntity, Integer>{
	
	List<ProcedimientoMuePLEntity> findByFkPlanMuestreoEntity_IdPlan(int idPlan);

}
