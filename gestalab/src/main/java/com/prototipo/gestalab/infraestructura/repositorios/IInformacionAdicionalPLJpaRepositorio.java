package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionAdicionalPLEntity;

public interface IInformacionAdicionalPLJpaRepositorio extends JpaRepository<InformacionAdicionalPLEntity, Integer> {

}
