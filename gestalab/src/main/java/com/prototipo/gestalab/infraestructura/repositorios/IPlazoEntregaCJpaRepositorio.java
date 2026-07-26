package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlazoEntregaCEntity;

public interface IPlazoEntregaCJpaRepositorio extends JpaRepository<PlazoEntregaCEntity, Integer>{

}
