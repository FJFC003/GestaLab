package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Catalogo Parametros")
public class CatalogoParametrosCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParametroC;
	@Column(length = 80)
	private String condicionParametroC;
	private String ensayoParametroC;
	private String tecnicaParametroC;
	private String procedimientoInternoParametroC;
	private String normaReferencialParametroC;
	private String unidadParametroC;
	private String rangoTrabajoParametroC;

}
