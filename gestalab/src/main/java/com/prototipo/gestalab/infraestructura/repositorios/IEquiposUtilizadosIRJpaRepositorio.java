package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.EquiposUtilizadosIREntity;

public interface IEquiposUtilizadosIRJpaRepositorio extends JpaRepository<EquiposUtilizadosIREntity, Integer>{
	
	List<EquiposUtilizadosIREntity> findByFkInformeEntity_IdInforme(int idInforme);

}
