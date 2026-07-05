package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.EEPPLEntity;

public interface IEEPPLJpaRepositorio extends JpaRepository<EEPPLEntity, Integer> {

}
