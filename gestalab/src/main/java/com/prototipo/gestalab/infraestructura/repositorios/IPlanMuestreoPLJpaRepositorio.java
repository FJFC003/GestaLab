package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlanMuestreoPLEntity;

public interface IPlanMuestreoPLJpaRepositorio extends JpaRepository<PlanMuestreoPLEntity, Integer>{

}
