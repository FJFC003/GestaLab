package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.InformeResultadosIREntity;

public interface IInformeResultadosIRJpaRepositorio extends JpaRepository<InformeResultadosIREntity, Integer>{
	
	Optional<InformeResultadosIREntity> findByFkOrdenTrabajoEntity_IdOT(int idOT);

}
