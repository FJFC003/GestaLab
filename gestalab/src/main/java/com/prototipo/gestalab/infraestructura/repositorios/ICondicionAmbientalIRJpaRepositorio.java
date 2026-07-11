package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.CondicionAmbientalIREntity;

public interface ICondicionAmbientalIRJpaRepositorio extends JpaRepository<CondicionAmbientalIREntity, Integer>{

}
