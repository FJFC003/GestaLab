package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.ResultadosIREntity;

public interface IResultadosIRJpaRepositorio extends JpaRepository<ResultadosIREntity, Integer>{
	
	List<ResultadosIREntity> findByFkInformeEntity_IdInforme(int idInforme);

}
