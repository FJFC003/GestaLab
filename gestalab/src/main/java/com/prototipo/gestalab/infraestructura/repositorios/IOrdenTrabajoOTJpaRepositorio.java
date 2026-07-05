package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.OrdenTrabajoOTEntity;

public interface IOrdenTrabajoOTJpaRepositorio extends JpaRepository<OrdenTrabajoOTEntity, Integer>{

}
