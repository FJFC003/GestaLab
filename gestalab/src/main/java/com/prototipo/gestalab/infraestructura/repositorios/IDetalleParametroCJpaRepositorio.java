package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleParametroCEntity;

public interface IDetalleParametroCJpaRepositorio extends JpaRepository<DetalleParametroCEntity, Integer> {

	List<DetalleParametroCEntity> findByFkDetalleCEntity_IdDetalleC(int idDetalleC);

	void deleteByFkDetalleCEntity_IdDetalleC(int idDetalleC);

}
