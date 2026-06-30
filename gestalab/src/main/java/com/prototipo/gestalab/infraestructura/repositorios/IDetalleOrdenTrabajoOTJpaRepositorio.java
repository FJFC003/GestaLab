package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleOrdenTrabajoOTEntity;

public interface IDetalleOrdenTrabajoOTJpaRepositorio extends JpaRepository<DetalleOrdenTrabajoOTEntity, Integer>{

}
