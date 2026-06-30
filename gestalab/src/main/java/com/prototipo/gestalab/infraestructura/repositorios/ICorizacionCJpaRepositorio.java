package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.CotizacionCEntity;

public interface ICorizacionCJpaRepositorio extends JpaRepository<CotizacionCEntity, Integer>{

}
