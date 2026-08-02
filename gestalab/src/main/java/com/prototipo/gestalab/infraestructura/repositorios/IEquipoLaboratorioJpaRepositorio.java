package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.EquipoLaboratorioEntity;

public interface IEquipoLaboratorioJpaRepositorio extends JpaRepository<EquipoLaboratorioEntity, Integer>{
	
	List<EquipoLaboratorioEntity> findByEstadoEquipoLabTrue();

}
