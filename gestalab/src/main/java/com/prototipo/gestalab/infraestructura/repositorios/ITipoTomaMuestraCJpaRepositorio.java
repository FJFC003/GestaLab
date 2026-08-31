package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.TipoTomaMuestraCEntity;

public interface ITipoTomaMuestraCJpaRepositorio extends JpaRepository<TipoTomaMuestraCEntity, Integer> {

}
