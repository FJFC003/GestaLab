package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "DetalleParametro")
public class DetalleParametroCEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleParametroC;

	// Excluido de toString y equals: el padre tiene la lista de hijos y Lombok
	// entraria en recursion infinita al recorrer la relacion en los dos sentidos.
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(name = "fk_detalle")
	private DetalleCEntity fkDetalleCEntity;

	@ManyToOne
	@JoinColumn(name = "fk_parametro")
	private CatalogoParametrosCEntity fkCatalogoParametroEntity;

	// El limite maximo permisible aplica al parametro, no al grupo de servicio.
	@ManyToOne
	@JoinColumn(name = "fk_lmp")
	private LmpCEntity fkLmpEntity;

}
