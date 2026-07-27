package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.PlanMuestreoPLEntity;

public interface IPlanMuestreoPLJpaRepositorio extends JpaRepository<PlanMuestreoPLEntity, Integer>{
	
	List<PlanMuestreoPLEntity> findByFkDetalleCEntity_IdDetalleC(int idDetalleC);

	List<PlanMuestreoPLEntity> findByFkDetalleCEntity_FkCotizacionCEntity_IdCotizacionC(int idCotizacionC);

	List<PlanMuestreoPLEntity> findByFkResponsableEntity_IdEmpleado(int idEmpleado);

}
