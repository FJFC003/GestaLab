package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.NormaParametroLmpCEntity;

public interface INormaParametroLmpCJpaRepositorio extends JpaRepository<NormaParametroLmpCEntity, Integer>{
	
	List<NormaParametroLmpCEntity> findByFkNormaEntity_IdCatalogoNormServi(int idCatalogoNormServi);

}
