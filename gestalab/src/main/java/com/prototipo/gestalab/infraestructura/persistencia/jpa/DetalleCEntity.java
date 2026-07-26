package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "DetalleCotizacion")
public class DetalleCEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleC;
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
    @JoinColumn(name = "fk_lmp")
    private LmpCEntity fkLmpEntity;
 
    @ManyToOne
    @JoinColumn(name = "fk_descripcion_servicio")
    private DescripcionServicioCEntity fkDescripcionServicioEntity;
 
    @ManyToOne
    @JoinColumn(name = "fk_plazo_entrega")
    private PlazoEntregaCEntity fkPlazoEntregaEntity;
    
    @OneToMany(mappedBy = "fkDetalleCEntity")
    private List<PlanMuestreoPLEntity> listaPlanes = new ArrayList<>();

}
