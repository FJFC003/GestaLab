package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.LmpCEntity;

public interface ILmpCJpaRepositorio extends JpaRepository<LmpCEntity, Integer>{

}
