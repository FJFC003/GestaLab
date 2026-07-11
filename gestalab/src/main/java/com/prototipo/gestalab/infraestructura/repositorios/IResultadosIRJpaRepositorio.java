package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.ResultadosIREntity;

public interface IResultadosIRJpaRepositorio extends JpaRepository<ResultadosIREntity, Integer>{

}
