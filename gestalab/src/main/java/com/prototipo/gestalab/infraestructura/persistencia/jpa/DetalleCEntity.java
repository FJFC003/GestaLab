package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
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
@Table(name = "DetalleCotizacion")
public class DetalleCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleC;
	@Column(length = 80)
	private String descripcionDetalleC;
	private String plazoEntregaDetalleC;
	private int cantidadPuntosDetalleC;
	private double precioUnitarioDetalleC;
	private double precioTotalDetalleC;
	private String condicionDetalleC;
	
	@ManyToOne
    @JoinColumn(name = "fk_cotizacion")
    private CotizacionCEntity fkCotizacionCEntity;

    @ManyToOne
    @JoinColumn(name = "fk_parametro")
    private CatalogoParametrosCEntity fkCatalogoParametroEntity;

    @ManyToOne
    @JoinColumn(name = "fk_norma_servicio")
    private CatalogoNormServiCEntity fkCatalogoNormServiEntity;

}
