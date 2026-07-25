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
@Table(name = "CondicionParametro")
public class CondicionParametroCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCondicionParametroC;
	private String codigoCondicionParametroC;
	private String descripcionCondicionParametroC;

	@OneToMany(mappedBy = "fkCondicionParametroEntity")
	private List<CatalogoParametrosCEntity> listaParametros = new ArrayList<>();

}
