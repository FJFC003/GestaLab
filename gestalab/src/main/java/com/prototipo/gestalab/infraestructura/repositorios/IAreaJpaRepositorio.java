package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.AreaEntity;

public interface IAreaJpaRepositorio extends JpaRepository<AreaEntity, Integer>{
	
	

}
