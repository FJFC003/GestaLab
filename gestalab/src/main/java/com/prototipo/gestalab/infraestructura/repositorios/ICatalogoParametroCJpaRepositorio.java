package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoParametrosCEntity;

public interface ICatalogoParametroCJpaRepositorio extends JpaRepository<CatalogoParametrosCEntity, Integer>{

}
