package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.CargoEntity;

public interface ICargoJpaRepositorio extends JpaRepository<CargoEntity, Integer> {

}
