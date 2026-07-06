package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.CotizacionCEntity;

public interface ICotizacionCJpaRepositorio extends JpaRepository<CotizacionCEntity, Integer>{

}
