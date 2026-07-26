package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "NormaParametroLmp")
public class NormaParametroLmpCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNormaParametroLmpC;
 
	@ManyToOne
	@JoinColumn(name = "fk_norma")
	private CatalogoNormServiCEntity fkNormaEntity;
 
	@ManyToOne
	@JoinColumn(name = "fk_parametro")
	private CatalogoParametrosCEntity fkParametroEntity;
 
	@ManyToOne
	@JoinColumn(name = "fk_lmp")
	private LmpCEntity fkLmpEntity;

}
