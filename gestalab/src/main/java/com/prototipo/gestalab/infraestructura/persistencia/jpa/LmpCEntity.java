package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Lmp")
public class LmpCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLmpC;
	private String codigoLmpC;
	private String valorLmpC;
 
	@OneToMany(mappedBy = "fkLmpEntity")
	private List<NormaParametroLmpCEntity> listaNormaParametroLmp = new ArrayList<>();
 
	// El LMP aplica al parametro, por eso apunta a la tabla hija DetalleParametro.
	@OneToMany(mappedBy = "fkLmpEntity")
	private List<DetalleParametroCEntity> listaDetalles = new ArrayList<>();

}
