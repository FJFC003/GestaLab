package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformacionMatrizPLEntity;

public interface IInformacionMatrizPLJpaRepositorio extends JpaRepository<InformacionMatrizPLEntity, Integer>{

}
