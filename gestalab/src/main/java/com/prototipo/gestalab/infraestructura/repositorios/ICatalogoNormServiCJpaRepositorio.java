package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoNormServiCEntity;

public interface ICatalogoNormServiCJpaRepositorio extends JpaRepository<CatalogoNormServiCEntity, Integer>{

}
