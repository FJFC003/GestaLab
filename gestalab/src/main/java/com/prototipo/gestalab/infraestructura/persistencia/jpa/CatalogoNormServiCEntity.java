package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Normas")
public class CatalogoNormServiCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCatalogoNormServi;
	@Column(length = 80)
	private String parametroCatalogoNormServiEntity;
	private String lmpCatalogoNormServiEntity;

	@OneToMany(mappedBy = "fkCatalogoNormServiEntity")
    private List<DetalleCEntity> listaDetalles = new ArrayList<>();
	
}
