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
@Table(name = "DescripcionServicio")
public class DescripcionServicioCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDescripcionServicioC;
	private String codigoDescripcionServicioC;
	private String textoDescripcionServicioC;
 
	@OneToMany(mappedBy = "fkDescripcionServicioEntity")
	private List<DetalleCEntity> listaDetalles = new ArrayList<>();

}
