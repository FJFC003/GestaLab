package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Cotizacion")
public class CotizacionCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCotizacionC;
	@Column(length = 80)
	private Date fechaElaboracionCotizacionC;
	private String vigenciaDiasCotizacionC;
	private String elaboradoPorCotizacionC;
	private double subtotalAgua;
	private double subtotalRuido;
	private double subtotalEmiciones;
	private double subtotalCalidad;
	private double subtotalSuelo;
	private double costoLogistica;
	private double Iva;
	private double TotalCotizacionC;
	
    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private ClienteCEntity fkClienteCEntity;

    @ManyToOne
    @JoinColumn(name = "fk_termino_condicion") 
    private CatalogoTerminosCondiCEntity fkCatalogoTerminoCondiEntity;

    @OneToMany(mappedBy = "fkCotizacionCEntity")
    private List<DetalleCEntity> listaDetalles = new ArrayList<>();

}
