package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.DatosLaboratorioIREntity;

public interface IDatosLaboratorioIRJpaRepositorio extends JpaRepository<DatosLaboratorioIREntity, Integer>{

}
