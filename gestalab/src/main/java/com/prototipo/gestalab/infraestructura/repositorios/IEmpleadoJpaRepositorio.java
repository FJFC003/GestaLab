package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.EmpleadoEntity;

public interface IEmpleadoJpaRepositorio extends JpaRepository<EmpleadoEntity, Integer> {

}
