package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleCEntity;

public interface IDetalleCJpaRepositorio extends JpaRepository<DetalleCEntity, Integer>{

}
