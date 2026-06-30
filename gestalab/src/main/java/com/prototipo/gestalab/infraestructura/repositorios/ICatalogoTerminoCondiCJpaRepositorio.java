package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.CatalogoTerminosCondiCEntity;

public interface ICatalogoTerminoCondiCJpaRepositorio extends JpaRepository<CatalogoTerminosCondiCEntity, Integer>{

}
